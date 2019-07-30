package org.patsimas.happy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "happiness")
public class Happiness {
	
    public static final Happiness SUPERB      = new Happiness(1l, "Superb");
    public static final Happiness VERY_GOOD   = new Happiness(2l, "Very good");
    public static final Happiness FAIRLY_GOOD = new Happiness(3l, "Fairly good");
    public static final Happiness GOOD        = new Happiness(4l, "Good");
    public static final Happiness FAIRLY_POOR = new Happiness(5l, "Fairly poor");
    public static final Happiness POOR        = new Happiness(6l, "Poor");
    public static final Happiness VERY_POOR   = new Happiness(7l, "Very poor");
    public static final Happiness AWFUL       = new Happiness(8l, "Awful");
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private  Long happinessId;
    
    
    @Column(name="description")
    private  String description;
    
    public Happiness() {
		
	}
    

	public Happiness(Long happinessId, String description) {
		
		this.happinessId = happinessId;
		this.description = description;
	}


    public Long getHappinessId() {
        return happinessId;
    }

    
    public String getDescription() {
        return description;
    }

    
    @Override
	public String toString() {
		return "Happiness [happinessId=" + happinessId + ", description=" + description + "]";
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
