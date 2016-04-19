package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publications {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(length = 500)
    private String paperTitle;
    @Column(length = 1000)
    private String authorList;
    private String publicationChannel;
    private int year;
    private String fileID;
    private String variable;
    private String dataset;
    private String instrument;
    private String conferenceName;
    private String conferenceLocation;
    private String dates;
    private int pages;
    
    
	public Publications() {
	}

	

	public Publications(String paperTitle, String authorList, String publicationChannel, int year, String fileID,
			String variable, String dataset, String instrument, String conferenceName, String conferenceLocation,
			String dates, int pages) {
		super();
		this.paperTitle = paperTitle;
		this.authorList = authorList;
		this.publicationChannel = publicationChannel;
		this.year = year;
		this.fileID = fileID;
		this.variable = variable;
		this.dataset = dataset;
		this.instrument = instrument;
		this.conferenceName = conferenceName;
		this.conferenceLocation = conferenceLocation;
		this.dates = dates;
		this.pages = pages;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getPaperTitle() {
		return paperTitle;
	}


	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}


	public String getAuthorList() {
		return authorList;
	}


	public void setAuthorList(String authorList) {
		this.authorList = authorList;
	}


	public String getPublicationChannel() {
		return publicationChannel;
	}


	public void setPublicationChannel(String publicationChannel) {
		this.publicationChannel = publicationChannel;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getFileID() {
		return fileID;
	}


	public void setFileID(String fileID) {
		this.fileID = fileID;
	}


	public String getVariable() {
		return variable;
	}


	public void setVariable(String variable) {
		this.variable = variable;
	}


	public String getDataset() {
		return dataset;
	}


	public void setDataset(String dataset) {
		this.dataset = dataset;
	}


	public String getInstrument() {
		return instrument;
	}


	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}


	public String getConferenceName() {
		return conferenceName;
	}


	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}


	public String getConferenceLocation() {
		return conferenceLocation;
	}


	public void setConferenceLocation(String conferenceLocation) {
		this.conferenceLocation = conferenceLocation;
	}


	public String getDates() {
		return dates;
	}


	public void setDates(String dates) {
		this.dates = dates;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}



	@Override
	public String toString() {
		return "Publications [id=" + id + ", paperTitle=" + paperTitle + ", authorList=" + authorList
				+ ", publicationChannel=" + publicationChannel + ", year=" + year + ", fileID=" + fileID + ", variable="
				+ variable + ", dataset=" + dataset + ", instrument=" + instrument + ", conferenceName="
				+ conferenceName + ", conferenceLocation=" + conferenceLocation + ", dates=" + dates + ", pages="
				+ pages + "]";
	}
	
	

    
}

