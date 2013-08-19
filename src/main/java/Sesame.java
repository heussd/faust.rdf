import java.io.InputStream;

import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParser;
import org.openrdf.rio.Rio;
import org.openrdf.rio.helpers.StatementCollector;

public class Sesame {

	public static void main(String[] args) throws Exception {
		java.net.URL documentUrl = Thread.currentThread().getContextClassLoader().getResource("./faust.rdf");
		InputStream inputStream = documentUrl.openStream();
		
		RDFParser rdfParser = Rio.createParser(RDFFormat.NQUADS);
		
		@SuppressWarnings("deprecation")
		org.openrdf.model.Graph myGraph = new org.openrdf.model.impl.GraphImpl();
		StatementCollector collector = new StatementCollector(myGraph);
		rdfParser.setRDFHandler(collector);
		
		rdfParser.parse(inputStream, documentUrl.toString());
	}
}
