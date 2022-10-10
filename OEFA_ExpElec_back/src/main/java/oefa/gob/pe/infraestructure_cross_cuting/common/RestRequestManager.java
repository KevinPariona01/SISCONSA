package oefa.gob.pe.infraestructure_cross_cuting.common;

import com.google.gson.JsonObject;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

@UtilityClass
@Log4j2
public class RestRequestManager {

	private final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).followRedirects(HttpClient.Redirect.ALWAYS).build();

	public String postRest(String uri, @NonNull JsonObject jsonObject, String authString) throws IOException, ExecutionException, InterruptedException {
		return postRest(uri, jsonObject.toString(), authString);
	}

	public String postRest(String uri, String rest, String authString) throws IOException, ExecutionException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.timeout(Duration.ofSeconds(4))
				.header("Content-Type", "application/json;charset=utf-8")
				.header("Authorization", "Basic " + authString)
				.POST(HttpRequest.BodyPublishers.ofString(rest))
				.build();

		return enviarRequest(request);
	}

	public String postRest(String uri, String rest) throws IOException, ExecutionException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.timeout(Duration.ofSeconds(4))
				.header("Content-Type", "application/json;charset=utf-8")
				.POST(HttpRequest.BodyPublishers.ofString(rest))
				.build();

		return enviarRequest(request);
	}

	public String getRest(String uri, String keyToken) throws IOException, ExecutionException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).timeout(Duration.ofSeconds(4)).GET().build();

		return enviarRequest(request);
	}

	public String postRESTCustomToken(String uri, String rest, String customToken) throws IOException, ExecutionException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder()
		                                 .uri(URI.create(uri))
		                                 .timeout(Duration.ofSeconds(4))
		                                 .header("Content-Type", "application/json;charset=utf-8")
		                                 .header("Authorization", customToken)
		                                 .POST(HttpRequest.BodyPublishers.ofString(rest))
		                                 .build();

		return enviarRequest(request);
	}

	private String enviarRequest(final HttpRequest request) throws IOException, InterruptedException, ExecutionException {
		HttpResponse<String> response = HTTP_CLIENT.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();

		if (response.statusCode() > 299 || response.statusCode() < 200) {
			String error = String.format("Al Hacer una solicitud a: %s%nSe obtuvo el error: %d%n Con el mensaje: %n%s", request.uri(), response.statusCode(), response.body());
			log.error(error);
			throw new IOException(error);
		}

		return response.body();
	}
}
