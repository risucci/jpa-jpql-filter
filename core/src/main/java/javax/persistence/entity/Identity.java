package javax.persistence.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract definition of an entity that uses sequential ID.<br>
 * <b>{@code @SequenceGenerator(name = "identity-sequence")}</b>. Changing all
 * other parameters is allowed.
 * 
 * @author Michel Risucci
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class Identity<ID extends Number> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private ID id;

	/**
	 * 
	 */
	public Identity() {
		super();
	}

	/**
	 * @return sequential number representing uniquely this entity
	 */
	public ID getId() {
		return id;
	}

	/**
	 * Automatic value: you must not change this. JPA will automatically
	 * increment this, sequentially.
	 * 
	 * @param id
	 *            sequential number representing uniquely this entity
	 */
	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identity<?> other = (Identity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
