package wecare.backend.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wecare.backend.exception.UserCollectionException;
import wecare.backend.model.ClinicAppointment;
import wecare.backend.model.ClinicDate;
import wecare.backend.model.Nurse;
import wecare.backend.model.PatientClinicProfile;
import wecare.backend.service.NurseService;

@RestController
@RequestMapping(value = "wecare")
@CrossOrigin(origins = "http://localhost:3000")
public class NurseController {

	@Autowired
	private NurseService nurseService;

	@PostMapping("/addNurse")
	public ResponseEntity<Nurse> addNurse(@RequestBody Nurse nurse) throws UserCollectionException {
		return new ResponseEntity<Nurse>(nurseService.addNurse(nurse), HttpStatus.OK);
	}

	@GetMapping("/getNurses")
	public List<Nurse> getNurse() {
		List<Nurse> nurses = nurseService.getAllNurses();
		return nurses;
	}

	@GetMapping("/getNurseProfile/{id}")
	public List<Nurse> getNurseProfileById(@PathVariable Integer id) {
		List<Nurse> nurse = nurseService.getNurseProfileById(id);
		return nurse;

	}

	@GetMapping("/getNurseProfileByName/{name}")
	public List<Nurse> getNurseProfileByName(@PathVariable String name) {
		List<Nurse> nurse = nurseService.getNurseProfileByName(name);
		return nurse;

	}

	@GetMapping("/getNurseProfileDetailsByClinic/{clinicId}")
	public List<Nurse> getNurseProfileByClinic(@PathVariable Integer clinicId) {
		List<Nurse> nurse = nurseService.getNurseProfileByClinic(clinicId);
		return nurse;

	}

	@GetMapping("/nurse/info/{id}")
	public Nurse getNurseInfo(@PathVariable Integer id){
		return nurseService.getNurse(id);
	}

	@GetMapping("/manage/queue/list/{id}")
	public List<ClinicAppointment> getQueue(@PathVariable Integer id){
		return nurseService.getQueue(id);
	}

	@GetMapping("/manage/queue/available/{id}")
	public ClinicDate getClinicDate(@PathVariable Integer id) throws ParseException {
		return nurseService.getClinicDate(id);
	}

	@GetMapping("/manage/queue/no/{id}")
	public Integer getCurrQueueNo(@PathVariable Integer id){
		return nurseService.getCurrQueueNo(id);
	}

	@GetMapping("/nurse/clinic/profile/{id}/{cid}")
	public PatientClinicProfile getClinicProfile(@PathVariable Integer id, @PathVariable Integer cid){
		return nurseService.getClinicProfile(id, cid);
	}

	@GetMapping("/manage/queue/start/{id}")
	public Boolean startClinic(@PathVariable Integer id){
		return nurseService.startClinic(id);
	}

	@GetMapping("/manage/queue/skip/{id}")
	public Boolean skipPatient(@PathVariable Integer id){
		return nurseService.skipPatient(id);
	}

	@GetMapping("/manage/queue/end/{id}")
	public Boolean endClinic(@PathVariable Integer id){
		return nurseService.endClinic(id);
	}
}
