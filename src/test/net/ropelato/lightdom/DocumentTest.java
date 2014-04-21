package net.ropelato.lightdom;

import org.junit.Test;

public class DocumentTest
{
	@org.junit.Test
	public void testFromFile() throws Exception
	{
		Document doc = Document.fromFile("TestFiles/books.xml");

		for(Element bookElement : doc.getRootElement().getElementsByName("book"))
		{
			String id = bookElement.getId();
			String author = bookElement.getElementByName("author").getText();
			String title = bookElement.getElementByName("title").getText();
			String genre = bookElement.getElementByName("genre").getText();
			String price = bookElement.getElementByName("price").getText();
			String publishDate = bookElement.getElementByName("publish_date").getText();
			String description = bookElement.getElementByName("description").getText();

			System.out.println("id: " + id);
			System.out.println("author: " + author);
			System.out.println("title: " + title);
			System.out.println("genre: " + genre);
			System.out.println("price: " + price);
			System.out.println("publishDate: " + publishDate);
			System.out.println("description: " + description);
			System.out.println("");
		}

		doc.toFile("TestFiles/books.out.xml");
	}

	@Test
	public void testToFile() throws Exception
	{
		// create document

		Document doc2 = new Document();
		Element rootElement = new Element("currencies");
		doc2.setRootElement(rootElement);

		// CHF

		Element chfElement = new Element("currency", "ccy1");
		rootElement.appendChild(chfElement);

		Element chfName = new Element("name");
		chfName.appendChild(new TextNode("Swiss Franc"));
		chfElement.appendChild(chfName);

		Element chfShort = new Element("shortForm");
		chfShort.appendChild(new TextNode("CHF"));
		chfElement.appendChild(chfShort);

		Element chfConversion = new Element("conversion");
		chfConversion.setAttribute("USD", "1.10");
		chfConversion.setAttribute("EUR", "0.83");
		chfConversion.setAttribute("GBP", "0.69");
		chfElement.appendChild(chfConversion);

		// EUR

		Element eurElement = new Element("currency", "ccy2");
		rootElement.appendChild(eurElement);

		Element eurName = new Element("name");
		eurName.appendChild(new TextNode("Euro"));
		eurElement.appendChild(eurName);

		Element eurShort = new Element("shortForm");
		eurShort.appendChild(new TextNode("EUR (€)"));
		eurElement.appendChild(eurShort);

		Element eurConversion = new Element("conversion");
		eurConversion.setAttribute("USD", "1.33");
		eurConversion.setAttribute("EUR", "1.00");
		eurConversion.setAttribute("GBP", "0.84");
		eurElement.appendChild(eurConversion);

		// USD

		Element usdElement = new Element("currency", "ccy3");
		rootElement.appendChild(usdElement);

		Element usdName = new Element("name");
		usdName.appendChild(new TextNode("US Dollar"));
		usdElement.appendChild(usdName);

		Element usdShort = new Element("shortForm");
		usdShort.appendChild(new TextNode("USD ($)"));
		usdElement.appendChild(usdShort);

		Element usdConversion = new Element("conversion");
		usdConversion.setAttribute("USD", "1.00");
		usdConversion.setAttribute("EUR", "0.75");
		usdConversion.setAttribute("GBP", "0.63");
		usdElement.appendChild(usdConversion);

		// USD

		Element gbpElement = new Element("currency", "ccy4");
		rootElement.appendChild(gbpElement);

		Element gbpName = new Element("name");
		gbpName.appendChild(new TextNode("Great Britain Pound"));
		gbpElement.appendChild(gbpName);

		Element gbpShort = new Element("shortForm");
		gbpShort.appendChild(new TextNode("GBP (£)"));
		gbpElement.appendChild(gbpShort);

		Element gbpConversion = new Element("conversion");
		gbpConversion.setAttribute("USD", "1.59");
		gbpConversion.setAttribute("EUR", "1.20");
		gbpConversion.setAttribute("GBP", "1.00");
		gbpElement.appendChild(gbpConversion);

		// write to file

		doc2.toFile("TestFiles/currencies.out.xml");
	}
}
