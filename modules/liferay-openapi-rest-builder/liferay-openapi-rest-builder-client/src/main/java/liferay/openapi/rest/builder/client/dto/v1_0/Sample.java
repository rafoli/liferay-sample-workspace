package liferay.openapi.rest.builder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import liferay.openapi.rest.builder.client.function.UnsafeSupplier;
import liferay.openapi.rest.builder.client.serdes.v1_0.SampleSerDes;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Sample implements Cloneable, Serializable {

	public static Sample toDTO(String json) {
		return SampleSerDes.toDTO(json);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<String, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	@Override
	public Sample clone() throws CloneNotSupportedException {
		return (Sample)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Sample)) {
			return false;
		}

		Sample sample = (Sample)object;

		return Objects.equals(toString(), sample.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return SampleSerDes.toJSON(this);
	}

}