package com.statebank.xoriant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.statebank.xoriant.dao.util.DBQueries;
import com.statebank.xoriant.dao.util.UserDTO;
import com.statebank.xoriant.resource.MailSender;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MailSender sender;

	@Override
	public String changePassword(UserDTO userDTO) {

		System.out.println("<<<<<<<<<<<<<<<<< IN PASSWORD CHANGED Method >>>>>>>>>>>>>>>>");
		UserDTO dto = UserDTO.getUserDetails(userDTO.getCustomerId(), jdbcTemplate);
		if (dto.getPassword().equals(userDTO.getOldPassword())) {

			int status = jdbcTemplate.update(DBQueries.UPDATE_PASSWORD, userDTO.getNewPassword(),userDTO.getCustomerId());

			if (status != 0) {
                
				sender.changePasswordDetails(userDTO.getNewPassword());
				return "<<<<<<<<<<<<<<<<<PASSWORD CHANGED SUCCESSFULLY >>>>>>>>>>>>>>>>";
			}

		}
		return "<<<<<<<<<<<<<<<<<PASSWORD NOT MATCHED >>>>>>>>>>>>>>>>";

	}

}
