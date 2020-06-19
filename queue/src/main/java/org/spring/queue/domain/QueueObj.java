package org.spring.queue.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class QueueObj implements Serializable {

	@Valid
	@NotNull
	private long code;

	@Valid
	@NotBlank
	@NotNull
	private String name;

	@JsonIgnore
	private String period;

}
