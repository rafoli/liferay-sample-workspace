package liferay.openapi.rest.builder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import liferay.openapi.rest.builder.client.dto.v1_0.Sample;
import liferay.openapi.rest.builder.client.json.BaseJSONParser;

/**
 * @author me
 * @generated
 */
@Generated("")
public class SampleSerDes {

	public static Sample toDTO(String json) {
		SampleJSONParser sampleJSONParser = new SampleJSONParser();

		return sampleJSONParser.parseToDTO(json);
	}

	public static Sample[] toDTOs(String json) {
		SampleJSONParser sampleJSONParser = new SampleJSONParser();

		return sampleJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Sample sample) {
		if (sample == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (sample.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(sample.getId()));

			sb.append("\"");
		}

		if (sample.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(sample.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SampleJSONParser sampleJSONParser = new SampleJSONParser();

		return sampleJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Sample sample) {
		if (sample == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (sample.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(sample.getId()));
		}

		if (sample.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(sample.getName()));
		}

		return map;
	}

	public static class SampleJSONParser extends BaseJSONParser<Sample> {

		@Override
		protected Sample createDTO() {
			return new Sample();
		}

		@Override
		protected Sample[] createDTOArray(int size) {
			return new Sample[size];
		}

		@Override
		protected void setField(
			Sample sample, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					sample.setId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					sample.setName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}