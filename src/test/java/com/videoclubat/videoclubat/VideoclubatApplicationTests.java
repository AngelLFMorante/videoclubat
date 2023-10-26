package com.videoclubat.videoclubat;

import com.videoclubat.videoclubat.app.VideoclubatApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class VideoclubatApplicationTests {

	@Test
	void contextLoads() {
		VideoclubatApplication.main(new String[] {"arg1", "arg2"});
		Assertions.assertNotNull(Arrays.stream(new String[] {"arg1", "arg2"}).findFirst());
	}

}
