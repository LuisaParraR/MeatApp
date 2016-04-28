package uts.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class PollBean implements Serializable {

	private String pollFilePath;
	private Polls polls;

	public PollBean() {
		// TODO Auto-generated constructor stub
	}

	public String getPollFilePath() {
		return pollFilePath;
	}

	public void setPollFilePath(String pollFilePath) throws JAXBException, IOException {
		this.pollFilePath = pollFilePath;

		JAXBContext jc = JAXBContext.newInstance(Polls.class);
		Unmarshaller u = jc.createUnmarshaller();

		FileInputStream fin = new FileInputStream(pollFilePath);
		polls = (Polls) u.unmarshal(fin);
		fin.close();
	}

	public Polls getPolls() {
		return polls;
	}

	public void setPolls(Polls polls) {
		this.polls = polls;
	}
}
