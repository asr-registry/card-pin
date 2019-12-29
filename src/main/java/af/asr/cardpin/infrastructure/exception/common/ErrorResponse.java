package af.asr.cardpin.infrastructure.exception.common;

import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse<T> {
	private long timestamp = Instant.now().toEpochMilli();
	private int status;
	private List<T> errors = new ArrayList<>();

}