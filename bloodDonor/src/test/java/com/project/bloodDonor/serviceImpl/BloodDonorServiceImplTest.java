package com.project.bloodDonor.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import com.project.bloodDonor.custom.exceptions.UserAlreadyDeletedException;
import com.project.bloodDonor.custom.exceptions.UserNotFoundException;
import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.entity.BloodDonorEnitity;
import com.project.bloodDonor.repository.BloodDonorRepository;
import com.project.bloodDonor.util.BloodDonorUtilTest;

@ExtendWith(MockitoExtension.class)
class BloodDonorServiceImplTest {

	@InjectMocks
	BloodDonorServiceImpl bloodDonorServiceImpl;

	@Mock
	BloodDonorRepository repo;

	// test case for save post method
	@Test
	void testAddNewDonor() {
	when(repo.save(Mockito.any())).thenReturn(BloodDonorUtilTest.prepareBloodDonorEntity());
	BloodDonorEnitity be=bloodDonorServiceImpl.addNewDonor(BloodDonorUtilTest.prepareBloodDonorDAO());
	assertEquals(BloodDonorUtilTest.prepareBloodDonorEntity().getAge(), be.getAge());
	}

	// test case for getAll method
	@Test
	void testGetAllusers() {
		when(repo.findAll()).thenReturn(BloodDonorUtilTest.prepareListofBloodDonorEntity());
		List<BloodDonorDAO> dao=bloodDonorServiceImpl.getAllusers();
		assertEquals(BloodDonorUtilTest.prepareBloodDonorEntity().getEmail(),dao.get(0).getEmail());
	}

	// test case for getMyProfile method based on email
	@Test
		void testGetMyProfile() throws UserNotFoundException {
			when(repo.findByEmail(Mockito.anyString())).thenReturn(BloodDonorUtilTest.prepareBloodDonorEntity());
			BloodDonorDAO o=(BloodDonorDAO) bloodDonorServiceImpl.getMyProfile("anan@gamil.com");
			assertEquals("anan@gamil.com",o.getEmail() );
			
		}

	// test case for getMyProfile method based on email - exception case
	@Test
			void testGetMyProfileThrowsException() throws UserNotFoundException {
				when(repo.findByEmail(Mockito.anyString())).thenReturn(null);
				Assertions.assertThrows(UserNotFoundException.class, () -> {
					bloodDonorServiceImpl.getMyProfile("anan@gamil.com");
		        }, "user " + "anan@gamil.com" + " not found");
				
			}

	// test case for update donor
	@Test
			void testupdateDonor() {
			when(repo.save(Mockito.any())).thenReturn(BloodDonorUtilTest.prepareBloodDonorEntity());
			BloodDonorEnitity be=bloodDonorServiceImpl.updateDonor(BloodDonorUtilTest.prepareBloodDonorDAO());
			assertEquals(BloodDonorUtilTest.prepareBloodDonorEntity().getAge(), be.getAge());
			}

	// test case for delete donor
	@Test
	void testDeleteDonor() throws UserAlreadyDeletedException {
		Mockito.doNothing().when(repo).deleteById(Mockito.anyInt());
		Object o = bloodDonorServiceImpl.deleteDonor(1);
		assertEquals("succesfully deleted donor", o.toString());
	}

	// test case for delete donor- exception
	@Test
	void testDeleteDonorException() throws UserAlreadyDeletedException {
		Mockito.doThrow(new EmptyResultDataAccessException(1)).when(repo).deleteById(Mockito.anyInt());
		Assertions.assertThrows(UserAlreadyDeletedException.class, () -> {
			bloodDonorServiceImpl.deleteDonor(1);
		}, "user with id " + 1 + " doesn't exists");
	}

	// test case for getMyProfile method based on id-exception
	@Test
	void testFindUserByIdException() {
		// Arrange
		Mockito.when(repo.findById(1)).thenReturn(null);
		// Act and assert
		Exception exception = assertThrows(UserNotFoundException.class, () -> {
			bloodDonorServiceImpl.findUserById(1);
		});

		String expectedMessage = "user with id 1 not found";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	// test case for getMyProfile method based on id
	@Test
	void testfindUserById() throws UserNotFoundException {
		BloodDonorEnitity e = new BloodDonorEnitity();
		e.setId(1);
		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(e);
		BloodDonorDAO d = bloodDonorServiceImpl.findUserById(1);
		assertEquals(1, d.getId());

	}

}
