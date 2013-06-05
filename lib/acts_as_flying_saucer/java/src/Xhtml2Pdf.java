import java.io.*;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.w3c.dom.Document;

public class Xhtml2Pdf
{
    public static void main(String[] args) throws Exception {
       
        String input = args[0];
        String url = new File(input).toURI().toURL().toString();
        String output = args[1];
        String baseUri = args[2];
        
        OutputStream os = new FileOutputStream(output);
        ITextRenderer renderer = new ITextRenderer();

        Document doc = renderer.getSharedContext().getUac().getXMLResource(url).getDocument();

        renderer.setDocument(doc, baseUri);
        renderer.layout();
        renderer.createPDF(os);
        os.close();

    }
}
