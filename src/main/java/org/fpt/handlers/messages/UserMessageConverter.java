package org.fpt.handlers.messages;

import java.io.IOException;
import java.io.InputStreamReader;

import org.fpt.orm.models.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;


public class UserMessageConverter extends AbstractHttpMessageConverter<User> {

	@Override
	protected boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	protected User readInternal(Class<? extends User> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {

		InputStreamReader reader = new InputStreamReader(inputMessage.getBody());
		User user = new User();
		return null;
	}

	@Override
	protected void writeInternal(User t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}
	
}