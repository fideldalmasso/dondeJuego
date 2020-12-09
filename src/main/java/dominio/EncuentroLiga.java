package dominio;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dj.encuentroLiga")
public class EncuentroLiga extends Encuentro {

}
