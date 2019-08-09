package org.patsimas.happy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "happiness")
public class Happiness {
	
    public static final Happiness SUPERB      = new Happiness(1l, "Superb", 95, 100);
    public static final Happiness VERY_GOOD   = new Happiness(2l, "Very good", 85, 94);
    public static final Happiness FAIRLY_GOOD = new Happiness(3l, "Fairly good", 75, 84);
    public static final Happiness GOOD        = new Happiness(4l, "Good", 65, 74);
    public static final Happiness FAIRLY_POOR = new Happiness(5l, "Fairly poor", 55, 64);
    public static final Happiness POOR        = new Happiness(6l, "Poor", 45, 54);
    public static final Happiness VERY_POOR   = new Happiness(7l, "Very poor", 35, 44);
    public static final Happiness AWFUL       = new Happiness(8l, "Awful", 0, 34);
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private  Long happinessId;
    
    @NotNull
    @Column(name="description")
    private  String description;
    
    @NotNull
    @Column(name="from_value")
    private  int fromValue;
    
    @NotNull
    @Column(name="to_value")
    private  int toValue;
    
    public Happiness() {
		
	}
    
    public Happiness(Long happinessId, @NotNull String description, @NotNull int fromValue, @NotNull int toValue) {
		super();
		this.happinessId = happinessId;
		this.description = description;
		this.fromValue = fromValue;
		this.toValue = toValue;
	}
    
	public Long getHappinessId() {
        return happinessId;
    }

    
    public String getDescription() {
        return description;
    }


	public int getFromValue() {
		return fromValue;
	}


	public int getToValue() {
		return toValue;
	}


	@Override
	public String toString() {
		return "Happiness [happinessId=" + happinessId + ", description=" + description + ", fromValue=" + fromValue
				+ ", toValue=" + toValue + "]";
	}


	public static final Happiness getHappinessFor(Long happinessId) throws Exception {

    	if (happinessId == SUPERB.getHappinessId()) {
            return SUPERB;
        }
        else if (happinessId == VERY_GOOD.getHappinessId()) {
            return VERY_GOOD;
        }
        else if (happinessId == FAIRLY_GOOD.getHappinessId()) {
            return FAIRLY_GOOD;
        }
        else if (happinessId == GOOD.getHappinessId()) {
            return GOOD;
        }
        else if (happinessId == FAIRLY_POOR.getHappinessId()) {
            return FAIRLY_POOR;
        }
        else if (happinessId == POOR.getHappinessId()) {
            return POOR;
        }
        else if (happinessId == VERY_POOR.getHappinessId()) {
            return VERY_POOR;
        }
        else if (happinessId == AWFUL.getHappinessId()) {
            return AWFUL;
        }
        else {
            throw new Exception("Invalid happiness id: " + happinessId);
        }
    }

}
