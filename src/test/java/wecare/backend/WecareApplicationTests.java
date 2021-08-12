package wecare.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import wecare.backend.exception.UserCollectionException;
import wecare.backend.model.ClinicSchedule;
import wecare.backend.model.Doctor;
import wecare.backend.model.DoctorSchedule;
import wecare.backend.repository.DoctorRepository;
import wecare.backend.service.DoctorService;

@SpringBootTest
class WecareApplicationTests {

	@Autowired
	DoctorService doctorservice;  
	
	@Autowired
	private DoctorRepository doctorRepo;	
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void saveDoctor() throws UserCollectionException {

		
	}
	

	@Test
	void getDoctorShedule() throws UserCollectionException {
		
//		doctorservice.getDoctorScheduleById(73);
//		doctorRepo.findByNameOrEmail("Prakash","prakash@gmail.com");
		
	}

}
