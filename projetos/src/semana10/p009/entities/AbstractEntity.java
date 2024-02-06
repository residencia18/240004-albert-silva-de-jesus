package p009.entities;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  public AbstractEntity() {
  }

  public AbstractEntity(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean hasNotId() {
    return id == null;
  }

  public boolean hasId() {
    return id != null;
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
    AbstractEntity other = (AbstractEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return String.format("Entidade %s id: %s", this.getClass().getName(), getId());
  }
}