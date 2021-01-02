import java.util.Calendar;
import java.util.GregorianCalendar;

public class Car {
	String Marca;
	String Model;
	int Anul_fabricatiei;
	int Km;
	String Culoare;
	String Norme_de_poluare;
	String Combustibil;
	String Cutie_de_viteze;
	String Caroserie;
	int Capacitate_cilindrica;
	int pret;
	
	public Car() {
		
	}

	public Car(String marca, String model, int anul_fabricatiei, int km, String culoare, String norme_de_poluare,
			String combustibil, String cutie_de_viteze, String caroserie, int capacitate_cilindrica, int pret) {

		Marca = marca;
		Model = model;
		Anul_fabricatiei = anul_fabricatiei;
		Km = km;
		Culoare = culoare;
		Norme_de_poluare = norme_de_poluare;
		Combustibil = combustibil;
		Cutie_de_viteze = cutie_de_viteze;
		Caroserie = caroserie;
		Capacitate_cilindrica = capacitate_cilindrica;
		this.pret = pret;
	}
	
	public String toString() {
		return "Car [Marca=" + Marca + ", Model=" + Model + ", Anul_fabricatiei=" + Anul_fabricatiei + ", Km=" + Km
				+ ", Culoare=" + Culoare + ", Norme_de_poluare=" + Norme_de_poluare + ", Combustibil=" + Combustibil
				+ ", Cutie_de_viteze=" + Cutie_de_viteze + ", Caroserie=" + Caroserie + ", Capacitate_cilindrica="
				+ Capacitate_cilindrica + ", pret=" + pret + "]";
	}
	
	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getAnul_fabricatiei() {
		return Anul_fabricatiei;
	}

	public void setAnul_fabricatiei(int anul_fabricatiei) {
		Anul_fabricatiei = anul_fabricatiei;
	}

	public int getKm() {
		return Km;
	}

	public void setKm(int km) {
		Km = km;
	}

	public String getCuloare() {
		return Culoare;
	}

	public void setCuloare(String culoare) {
		Culoare = culoare;
	}

	public String getNorme_de_poluare() {
		return Norme_de_poluare;
	}

	public void setNorme_de_poluare(String norme_de_poluare) {
		Norme_de_poluare = norme_de_poluare;
	}

	public String getCombustibil() {
		return Combustibil;
	}

	public void setCombustibil(String combustibil) {
		Combustibil = combustibil;
	}

	public String getCutie_de_viteze() {
		return Cutie_de_viteze;
	}

	public void setCutie_de_viteze(String cutie_de_viteze) {
		Cutie_de_viteze = cutie_de_viteze;
	}

	public String getCaroserie() {
		return Caroserie;
	}

	public void setCaroserie(String caroserie) {
		Caroserie = caroserie;
	}

	public int getCapacitate_cilindrica() {
		return Capacitate_cilindrica;
	}

	public void setCapacitate_cilindrica(int capacitate_cilindrica) {
		Capacitate_cilindrica = capacitate_cilindrica;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}
	
}