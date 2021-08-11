package liferay.openapi.rest.builder.client.function;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}