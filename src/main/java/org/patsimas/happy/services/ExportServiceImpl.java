package org.patsimas.happy.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.patsimas.happy.domain.User;
import org.patsimas.happy.dto.UserDto;
import org.patsimas.happy.repositories.UserRepository;
import org.patsimas.happy.utils.HeaderColumnNameAndOrderMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Service
public class ExportServiceImpl implements ExportService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	private ConversionService conversionService;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void exportUsersToCSV(HttpServletResponse response)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		LOGGER.info("Export data process for all users...");
		
		List<User> users = userRepository.findAll();

		List<UserDto> userDtos = new ArrayList<>(users.size());
		
		users.forEach(user -> {
			
			userDtos.add(conversionService.convert(user, UserDto.class));
		});
		
		String path = "andreas";

		createCsvFile(path, response, userDtos);
		
		LOGGER.info("Export data process for all users completed.");

	}

	private void createCsvFile(String path, HttpServletResponse response, List<UserDto> users)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		String filename = path + ".csv";

		response.setContentType("text/csv; charset=utf-8");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

		StatefulBeanToCsv<UserDto> writer = new StatefulBeanToCsvBuilder<UserDto>(response.getWriter())
				.withApplyQuotesToAll(false)
				.withMappingStrategy(new HeaderColumnNameAndOrderMappingStrategy<>(UserDto.class)).build();

		writer.write(users);

		response.getWriter().close();
	}

}
