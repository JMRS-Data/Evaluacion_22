package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Experiment;

public class ExperimentDOM {
	private String pathFile = "R:\\Clases\\Cuatrimerte IV 2017\\Desarrollo de aplicaciones II\\Unidad1\\Eclipse\\07-09-17\\JMRSUnidad22\\src\\data\\experiments.xml";

	public void add(Experiment data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element experiments = document.getDocumentElement();
			Element experiment = document.createElement("experiment");

			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			experiment.appendChild(id);

			Element title = document.createElement("title");
			title.appendChild(document.createTextNode(data.getTitle()));
			experiment.appendChild(title);

			Element description = document.createElement("description");
			description.appendChild(document.createTextNode(data.getDescription()));
			experiment.appendChild(description);

			Element creationDate = document.createElement("creationDate");
			creationDate.appendChild(document.createTextNode(data.getCreationDate()));
			experiment.appendChild(creationDate);

			Element modificationDate = document.createElement("modificationDate");
			modificationDate.appendChild(document.createTextNode(data.getModificationDate()));
			experiment.appendChild(modificationDate);

			experiments.appendChild(experiment);

			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("experiment");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element experiment = (Element) nodeList.item(i);
				if (experiment.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					experiment.getParentNode().removeChild(experiment);
				}

			}

			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Experiment data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("experiment");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element experiment = (Element) nodeList.item(i);
				if (experiment.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					experiment.getElementsByTagName("title").item(0).setTextContent(String.valueOf(data.getTitle()));
					experiment.getElementsByTagName("description").item(0)
							.setTextContent(String.valueOf(data.getDescription()));
					experiment.getElementsByTagName("creationDate").item(0)
							.setTextContent(String.valueOf(data.getCreationDate()));
					experiment.getElementsByTagName("modificationDate").item(0)
							.setTextContent(String.valueOf(data.getModificationDate()));

				}
			}

			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Experiment findById(String id) {
		Experiment experiment = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("experiment");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element e = (Element) nodeList.item(i);
				if (e.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					experiment = new Experiment();
					experiment.setId(id);
					experiment.setTitle(e.getElementsByTagName("title").item(0).getTextContent());
					experiment.setDescription(e.getElementsByTagName("description").item(0).getTextContent());
					experiment.setCreationDate(e.getElementsByTagName("creationDate").item(0).getTextContent());
					experiment.setModificationDate(e.getElementsByTagName("modificationDate").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return experiment;
	}

	public List<Experiment> getExperiments() {
		List<Experiment> experiments = new ArrayList<Experiment>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("experiment");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			Experiment experiment = new Experiment();
			experiment.setId(e.getElementsByTagName("id").item(0).getTextContent());
			experiment.setTitle(e.getElementsByTagName("title").item(0).getTextContent());
			experiment.setDescription(e.getElementsByTagName("description").item(0).getTextContent());
			experiment.setCreationDate(e.getElementsByTagName("creationDate").item(0).getTextContent());
			experiment.setModificationDate(e.getElementsByTagName("modificationDate").item(0).getTextContent());
			experiments.add(experiment);
		}
		return experiments;
	}
}