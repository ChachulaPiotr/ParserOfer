package Parsing;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Oferteo.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection.Response;
import sun.misc.OSEnvironment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class Scrapper {
	public static void main (String[] args) throws IOException,SQLException {
		int id=23849;
		int j=478;
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb",
							"postgres", "piotrek");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "DELETE from OFERTEO where ID >23849;";
			stmt.executeUpdate(sql);
			sql = "DELETE from branza where ID >23849;";
			stmt.executeUpdate(sql);
			sql = "DELETE from jednostkilokalne where ID >23849;";
			stmt.executeUpdate(sql);
			sql = "DELETE from obszar where ID >23849;";
			stmt.executeUpdate(sql);
			sql = "DELETE from opinie where ID >23849;";
			stmt.executeUpdate(sql);
			sql = "DELETE from pkd where ID >23849;";
			stmt.executeUpdate(sql);
			sql = "DELETE from weryfikacja where ID >23849;";
			stmt.executeUpdate(sql);
			c.commit();
			stmt.close();
			c.close();
		}
		catch ( Exception e ) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		/*try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb",
							"postgres", "piotrek");
			stmt = c.createStatement();
			//String sql = "DROP TABLE IF EXISTS OFERTEO";
			//stmt.executeUpdate(sql);
			String sql = "CREATE TABLE Oferteo " +
					"(ID INT    NOT NULL," +
					" nazwa_Firmy	TEXT, " +
					" imie_pierwsze	TEXT, " +
					" imie_drugie	TEXT, " +
					" nazwisko	TEXT," +
					" data_rozpoczecia_dzialalnosci	TEXT," +
					" nip	TEXT," +
					"kraj	TEXT," +
					"wojewodztwo	TEXT," +
					"powiat	TEXT," +
					"gmina	TEXT," +
					"miejscowosc	TEXT," +
					"kod_pocztowy	TEXT," +
					"poczta	TEXT," +
					"ulica	TEXT," +
					"numer_nieruchomosci	TEXT," +
					"adres_kontaktowy	TEXT," +
					"www	TEXT," +
					"telefon	TEXT," +
					"osoba_kontaktowa	TEXT," +
					"opis	TEXT," +
					"regon	TEXT," +
					"data_wpisu_regon	TEXT," +
					"data_Powstania	TEXT," +
					"podstawowa_Forma_prawna	TEXT," +
					"szczegolowa_Forma_prawna	TEXT," +
					"forma_wlasnosci	TEXT)";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS OPINIE";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE OPINIE (ID INT, OPINIA TEXT, OCENA TEXT, DATA TEXT)";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS PKD";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE PKD (ID INT, Kod_PKD TEXT, Nazwa TEXT)";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS branza";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE branza (ID INT, branza TEXT)";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS weryfikacja";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE weryfikacja (ID INT, weryfikacja TEXT)";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS obszar";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE obszar (ID INT, obszar TEXT)";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS JednostkiLokalne";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE JednostkiLokalne (ID INT, regon TEXT, nazwa TEXT, adres TEXT)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");*/
		//int id=0;
		for (;j<=12526;j++) {
			ArrayList<String> l = new ArrayList();
			Document doc = null;
			int licz1=0;
			while(licz1<10){
				try {
					System.out.println("1/ "+j+" - "+id);
					doc = Jsoup.parse(new URL("https://www.oferteo.pl/firmy/" + j), 5000);
					Document subDoc = null;
					Elements result = doc.select("tr.row.id-cust a.nounderline.no-redirection");
					for (Element link : result) {
						//System.out.println(link.attr("href")+"/");
						int licz2=0;
						while (licz2<10) {
							try {
								System.out.println(link.attr("href"));
								System.out.println("2/ " + j + " - " + id);
								subDoc = Jsoup.parse(new URL(link.attr("href")), 5000);
								String opis = null;
								try {
									opis = subDoc.select("p[class=word-break]").first().text().replace("'", "`");
								}
								catch (NullPointerException e){}
								List<String> branza = new ArrayList<String>();
								Elements subResultLinks = subDoc.select("p[class=word-break] a.underlined.space-to-touch");
								for (Element subLink : subResultLinks) {
									//System.out.println(link.text());
									branza.add(subLink.text().replace("'","`"));
								}
								String obszar = null;
								try {
									obszar = subDoc.select("div.col-xs-12.col-md-6 p[class=word-break]").last().text().replace("'", "`");
								}
								catch (NullPointerException e){}
								List<String> obszarDzialania = new ArrayList<>();
								try {
									for (String sub : obszar.split(", ")) {
										//System.out.println(sub);
										obszarDzialania.add(sub);
									}
								}
								catch (NullPointerException e){};
								List<String> weryfikacjaOferteo = new ArrayList<String>();
								subResultLinks = subDoc.select("div.uncover-panel-customer.no-margin-bottom-xs h5.ofe-tooltip-top");
								try {
									for (Element subLink : subResultLinks) {
										weryfikacjaOferteo.add(subLink.text().replace("'", "`"));
										//System.out.println(link.text());
									}
								}
								catch (NullPointerException e){};
								OSpecjaliscie oSpecjaliscie = new OSpecjaliscie(opis, branza, obszarDzialania, weryfikacjaOferteo);
								System.out.println(oSpecjaliscie.toString() + "\n");

								String adres = null;
								String nip = null;
								String www = null;
								String osobaKontaktowa = null;
								String telefon = null;
								try {
									adres = subDoc.select("div.row.no-padding[itemprop=address] div.col-xs-7.no-padding").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								try {
									nip = subDoc.select("div.row.no-padding div.col-xs-7.no-padding a.underlined.scrollLink[href=#dane-rejestrowe]").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								try {
									www = subDoc.select("div.row.no-padding.break-all div.col-xs-7.no-padding").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								try {
									osobaKontaktowa = subDoc.select("div.col-xs-4.no-padding:has(p:containsOwn(Osoba Kontaktowa)) + div.col-xs-7.no-padding").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								try {
									telefon = subDoc.select("meta").last().attr("content").replace("'", "`");
								}
								catch (NullPointerException e){};
								Kontakt kontakt = new Kontakt(adres, nip, www, telefon, osobaKontaktowa);
								System.out.println(kontakt.toString() + "\n");

								String nazwaFirmy=null;
								try {
									nazwaFirmy = subDoc.select("caption:has(h3:containsOwn(Firma)) + tbody td:containsOwn(Nazwa firmy) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String imiepierwsze=null;
								try {
									imiepierwsze = subDoc.select("caption:has(h3:containsOwn(Firma)) + tbody td:containsOwn(Imię (pierwsze)) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String imiedrugie=null;
								try {
									imiedrugie = subDoc.select("caption:has(h3:containsOwn(Firma)) + tbody td:containsOwn(Drugie imię) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String nazwisko=null;
								try {
									nazwisko = subDoc.select("caption:has(h3:containsOwn(Firma)) + tbody td:containsOwn(Nazwisko) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String dataRozpoczeciaDzialalnosci=null;
								try {
									dataRozpoczeciaDzialalnosci = subDoc.select("caption:has(h3:containsOwn(Firma)) + tbody td:containsOwn(Data rozpoczęcia działalności) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								nip = null;
								try {
									nip = subDoc.select("caption:has(h3:containsOwn(Firma)) + tbody td:containsOwn(NIP) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String regon = null;
								try {
									regon = subDoc.select("caption:has(h3:containsOwn(Firma)) + tbody td:containsOwn(Regon) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								Firma firma = new Firma(nazwaFirmy, imiepierwsze, imiedrugie, nazwisko, dataRozpoczeciaDzialalnosci, nip, regon);
								System.out.println(firma.toString() + "\n");

								List<SubOpinia> listOpinia = new ArrayList<SubOpinia>();
								Elements sbResultLinks = subDoc.select("div.col-xs-12.commentText.no-padding-left");
								for (Element sbLink:sbResultLinks) {
									SubOpinia subOpinia = new SubOpinia();
									subResultLinks = sbLink.select("p.word-break.no-margin-bottom[itemprop=description]");
									for (Element subLink : subResultLinks) {
										//System.out.println(subLink.text());
										//subOpinia.add(subLink.text().replace("'","`"));
										subOpinia.setOpinia(subLink.text().replace("'", "`"));
									}
									subResultLinks = sbLink.select("div.col-xs-12.comment-title.no-margin span");
									for (Element subLink : subResultLinks) {
										//System.out.println(subLink.text());
										//opinia.add(subLink.text().replace("'","`"));
										subOpinia.setData(subLink.text().replace("'", "`"));
									}
									subResultLinks = sbLink.select("div.col-xs-12.comment-title.no-margin div.row.margin-top-5 img");
									for (Element subLink : subResultLinks) {
										//System.out.println(subLink.text());
										//opinia.add(subLink.text().replace("'","`"));
										subOpinia.setOcena(subLink.attr("title").replace("'", "`"));
									}
									listOpinia.add(subOpinia);
								}
								Opinie opinie = new Opinie(listOpinia);
								System.out.println(opinie.toString());

								String kraj=null;
								try {
									kraj = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Kraj) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String wojewodztwo=null;
								try {
									wojewodztwo = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Województwo) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String powiat=null;
								try {
									powiat = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Powiat) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String gmina=null;
								try {
									gmina = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Gmina) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String miejscowosc=null;
								try {
									miejscowosc = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Miejscowość) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String kodPocztowy=null;
								try {
									kodPocztowy = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Kod pocztowy) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String poczta = null;
								try {
									poczta = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Poczta) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String ulica=null;
								try {
									ulica = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Ulica) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String numerNieruchomosci=null;
								try {
									numerNieruchomosci = subDoc.select("caption:has(h3:containsOwn(Siedziba)) + tbody td:containsOwn(Numer nieruchomości) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								Siedziba siedziba = new Siedziba(kraj, wojewodztwo, powiat, gmina, miejscowosc, kodPocztowy, poczta, ulica, numerNieruchomosci);
								System.out.println(siedziba.toString() + "\n");

								String podstawowaFormaPrawna=null;
								try {
									podstawowaFormaPrawna = subDoc.select("caption:has(h3:containsOwn(Forma prawna)) + tbody td:containsOwn(Kod i nazwa podstawowej formy prawnej) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String szczegolowaFormaPrawna= null;
								try {
									szczegolowaFormaPrawna = subDoc.select("caption:has(h3:containsOwn(Forma prawna)) + tbody td:containsOwn(Kod i nazwa szczegółowej formy prawnej) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String formaWlasnosci=null;
								try {
									formaWlasnosci = subDoc.select("caption:has(h3:containsOwn(Forma prawna)) + tbody td:containsOwn(Kod i nazwa formy własności) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								FormaPrawna formaPrawna = new FormaPrawna(podstawowaFormaPrawna, szczegolowaFormaPrawna, formaWlasnosci);
								System.out.println(formaPrawna.toString() + "\n");

								dataRozpoczeciaDzialalnosci = null;
								String dataWpisuRegon=null;
								try {
									dataWpisuRegon = subDoc.select("caption:has(h3:containsOwn(Rejestracja)) + tbody td:containsOwn(Data wpisu do bazy REGON) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								String dataPowstania=null;
								try {
									dataPowstania = subDoc.select("caption:has(h3:containsOwn(Rejestracja)) + tbody td:containsOwn(Data powstania) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								try {
									dataRozpoczeciaDzialalnosci = subDoc.select("caption:has(h3:containsOwn(Rejestracja)) + tbody td:containsOwn(Data rozpoczęcia działalności) + td").text().replace("'", "`");
								}
								catch (NullPointerException e){};
								Rejestracja rejestracja = new Rejestracja(dataWpisuRegon, dataPowstania, dataRozpoczeciaDzialalnosci);
								System.out.println(rejestracja.toString() + "\n");

								regon = null;
								String nazwa = null;
								adres = null;
								int i = 1;
								SubJednostkiLokalne subJednostkiLokalne;
								List<SubJednostkiLokalne> listJednostkiLokalne = new ArrayList<SubJednostkiLokalne>();
								subResultLinks = subDoc.select("caption:has(h3:containsOwn(Jednostki lokalne)) ~ tbody td");
								for (Element subLink : subResultLinks) {
									//System.out.println(subLink.text());
									switch (i) {
										case 1:
											regon = subLink.text().replace("'","`");
											i=2;
											break;
										case 2:
											nazwa = subLink.text().replace("'","`");
											i=3;
											break;
										case 3:
											adres = subLink.text().replace("'","`");
											subJednostkiLokalne = new SubJednostkiLokalne(regon,nazwa,adres);
											//System.out.println(regon+nazwa+adres);
											listJednostkiLokalne.add(subJednostkiLokalne);
											i=1;
											break;
										default:
									}
								}
								JednostkiLokalne jednostkiLokalne = new JednostkiLokalne(listJednostkiLokalne);
								System.out.println(jednostkiLokalne.toString() + "\n");

								String kodPKD = null;
								nazwa = null;
								SubPKD subPKD = null;
								List<SubPKD> listPKD = new ArrayList<SubPKD>();
								i = 1;
								subResultLinks = subDoc.select("caption:has(h3:containsOwn(Zakres działalności (PKD))) ~ tbody td");
								for (Element subLink : subResultLinks) {
									//System.out.println(subLink.text());
									switch (i) {
										case 1:
											kodPKD = subLink.text().replace("'","`");
											i = 2;
											break;
										case 2:
											nazwa = subLink.text().replace("'","`");
											i = 1;
											subPKD = new SubPKD(kodPKD, nazwa);
											listPKD.add(subPKD);
											break;
										default:
									}
								}
								PKD pkd = new PKD(listPKD);
								System.out.println(pkd.toString() + "\n");
								System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
								System.out.println();
								id += 1;

								//String ospec = oSpecjaliscie.getOpis().replace("'", "`");
								//String kont = kontakt.toString().replace("'", "`");
								//String firm = firma.toString().replace("'", "`");
								//String sied = siedziba.toString().replace("'", "`");
								//String rejs = rejestracja.toString().replace("'", "`");
								//String form = formaPrawna.toString().replace("'", "`");
								//String jedn = jednostkiLokalne.toString().replace("'", "`");
								//String pk = pkd.toString().replace("'", "`");
								//String op = opinie.toString().replace("'","`");
								try {
									Class.forName("org.postgresql.Driver");
									c = DriverManager
											.getConnection("jdbc:postgresql://localhost:5432/testdb",
													"postgres", "piotrek");
									c.setAutoCommit(false);
									System.out.println("Opened database successfully");

									stmt = c.createStatement();
									/*String sql = "INSERT INTO OFERTEO (ID,OSPECJALISCIE,KONTAKT,FIRMA,SIEDZIBA,FORMAPRAWNA,REJESTRACJA) "
											+ "VALUES (" + id + ", '" + ospec + "', '" + kont + "', '" + firm + "', '" + sied + "', '" + form + "', '" + rejs + "');";*/
									String sql = "INSERT INTO Oferteo " +
											"(ID ," +
											" nazwa_Firmy	, " +
											" imie_pierwsze	, " +
											" imie_drugie	, " +
											" nazwisko	," +
											" data_rozpoczecia_dzialalnosci	," +
											" nip	," +
											"kraj	," +
											"wojewodztwo	," +
											"powiat	," +
											"gmina	," +
											"miejscowosc	," +
											"kod_pocztowy	," +
											"poczta	," +
											"ulica	," +
											"numer_nieruchomosci	," +
											"adres_kontaktowy	," +
											"www	," +
											"telefon	," +
											"osoba_kontaktowa	," +
											"regon	," +
											"podstawowa_Forma_prawna	," +
											"szczegolowa_Forma_prawna	," +
											"forma_wlasnosci	," +
											"data_wpisu_regon	," +
											"data_Powstania," +
											"opis	) VALUES ("+id+" ," +
											" '"+firma.getNazwaFirmy()+"'	, " +
											" '"+firma.getImiepierwsze()+"'	, " +
											" '"+firma.getImiedrugie()+"'	, " +
											" '"+firma.getNazwisko()+"'	," +
											" '"+firma.getDataRozpoczeciaDzialalnosci()+"'	," +
											" '"+firma.getNip()+"'	," +
											"'"+siedziba.getKraj()+"'	," +
											"'"+siedziba.getWojewodztwo()+"'	," +
											"'"+siedziba.getPowiat()+"'	," +
											"'"+siedziba.getGmina()+"'	," +
											"'"+siedziba.getMiejscowosc()+"'	," +
											"'"+siedziba.getKodPocztowy()+"'	," +
											"'"+siedziba.getPoczta()+"'	," +
											"'"+siedziba.getUlica()+"'	," +
											"'"+siedziba.getNumerNieruchomosci()+"'	," +
											"'"+kontakt.getAdres()+"'	," +
											"'"+kontakt.getWww()+"'	," +
											"'"+kontakt.getTelefon()+"'	," +
											"'"+kontakt.getOsobaKontaktowa()+"'	," +
											"'"+firma.getRegon()+"'	," +
											"'"+formaPrawna.getPodstawowaFormaPrawna()+"'	," +
											"'"+formaPrawna.getSzczegolowaFormaPrawna()+"'	," +
											"'"+formaPrawna.getFormaWlasnosci()+"'	," +
											"'"+rejestracja.getDataWpisuRegon()+"'	," +
											"'"+rejestracja.getDataPowstania()+"'	," +
											"'"+oSpecjaliscie.getOpis()+"')";
									stmt.executeUpdate(sql);
									for (SubOpinia op : listOpinia) {

										sql = "INSERT INTO OPINIE (ID, OPINIA, OCENA, DATA) VALUES ('"+id+"', '"+op.getOpinia()+"', '"+op.getOcena()+"', '"+op.getData()+"');";
										stmt.executeUpdate(sql);
									}
									for (SubPKD pk : listPKD) {
										String pkk = pk.getKodPKD().replace("'","`");
										String pkn = pk.getNazwa().replace("'","`");
										sql = "INSERT INTO PKD (ID, Kod_PKD, Nazwa) VALUES ('"+id+"', '"+pkk+"', '" + pkn+ "');";
										stmt.executeUpdate(sql);
									}
									for (String br: oSpecjaliscie.getBranza()) {
										sql = "INSERT INTO branza (ID, branza) VALUES ("+id+", '"+br+ "')";
										stmt.executeUpdate(sql);
									}
									for (String wer:oSpecjaliscie.getWeryfikacjaOferteo()){
										sql = "INSERT INTO weryfikacja VALUES ("+id+", '"+wer+"')";
										stmt.executeUpdate(sql);
									}
									for (String ob: oSpecjaliscie.getObszarDzialania()){
										sql = "INSERT INTO obszar VALUES ( "+id+", '"+ob+"')";
										stmt.executeUpdate(sql);
									}
									for (SubJednostkiLokalne jl: listJednostkiLokalne){
										String jlr = jl.getRegon().replace("'","`");
										String jln = jl.getNazwa().replace("'","`");
										String jla = jl.getAdres().replace("'","`");
										sql = "INSERT INTO JednostkiLokalne (id, regon, nazwa, adres) VALUES ( "+id+", '"+jlr+"', '"+jln+"', '"+jla+"')";
										stmt.executeUpdate(sql);
									}
									System.out.println(j + " -" + id);
									stmt.close();
									c.commit();
									c.close();
								} catch (Exception e) {
									System.err.println(e.getClass().getName() + ": " + e.getMessage());
									System.exit(0);
								}
								break;
							} catch (SocketTimeoutException ex) {
								l.add("text...");
								System.out.println("Socket");
								licz2 += 1;
								if (licz2 >= 10){
									try {
										URL url = new URL("https://www.google.pl/");
										URLConnection connection = url.openConnection();
										connection.connect();
										break;
									}
									catch (Exception exc){
										System.out.println("No internet connection");
										licz2 = 0;
									}
								}
							} catch (IOException e) {
								System.out.println("IO");
								licz2 += 1;
								while (true) {
									try {
										System.out.println("Checking connection");
										URL url = new URL("https://www.google.pl/");
										URLConnection connection = url.openConnection();
										connection.connect();
										if (licz2 >=10) {
											Class.forName("org.postgresql.Driver");
											c = DriverManager
													.getConnection("jdbc:postgresql://localhost:5432/testdb",
															"postgres", "piotrek");
											c.setAutoCommit(false);
											System.out.println("Opened database successfully");

											stmt = c.createStatement();
											id += 1;
											String sql = "INSERT INTO OFERTEO (ID,nazwa_Firmy) "
													+ "VALUES (" + id + ", '" + link.attr("href") + "');";
											stmt.executeUpdate(sql);
											System.out.println(j + " -" + id);
											stmt.close();
											c.commit();
											c.close();
										}
										break;
									} catch (Exception e2) {
										System.out.println("No internet connection");
										licz2 = 0;
										//System.err.println(e.getClass().getName() + ": " + e.getMessage());
										//System.exit(0);
									}
								}
							}
						}
					}
				break;
				}
				catch (SocketTimeoutException ex){
					l.add("text...");
					licz1 += 1;
					System.out.println(licz1);
					if (licz1 == 10){
						try {
							System.out.println("Checking connection");
							URL url = new URL("https://www.google.pl/");
							URLConnection connection = url.openConnection();
							connection.connect();
							break;
						}
						catch (Exception exc){
							System.out.println("No internet connection");
							licz1 = 0;
						}
					}
				}
				catch (IOException e) {
					licz1+=1;
					 while (true) {
						try {
							System.out.println("Checking connection");
							URL url = new URL("https://www.google.pl/");
							URLConnection connection = url.openConnection();
							connection.connect();
							if (licz1 >= 10) {
								id += 1;
								Class.forName("org.postgresql.Driver");
								c = DriverManager
										.getConnection("jdbc:postgresql://localhost:5432/testdb",
												"postgres", "piotrek");
								c.setAutoCommit(false);
								System.out.println("Opened database successfully");

								stmt = c.createStatement();
								String sql = "INSERT INTO OFERTEO (ID,nazwa_Firmy) "
										+ "VALUES (" + id + ", 'https://www.oferteo.pl/firmy/" + j + "');";
								stmt.executeUpdate(sql);
								System.out.println(j + " -" + id);
								stmt.close();
								c.commit();
								c.close();
							}
							break;
						} catch (Exception e1) {
							System.out.println("No internet connection");
							licz1 = 0;
							//System.err.println(e.getClass().getName() + ": " + e.getMessage());
							//System.exit(0);
						}
					}
				}
			}
		}
		/*Document subDoc = Jsoup.parse(new URL("https://grafka.oferteo.pl/"),3000);
		String kodPKD = null;
		String nazwa = null;
		SubPKD subPKD;
		List<SubPKD> listPKD = new ArrayList<SubPKD>();
		int i=1;
		Elements subResultLinks = subDoc.select("caption:has(h3:containsOwn(Zakres działalności (PKD))) ~ tbody td");
		for (Element subLink : subResultLinks) {
			//System.out.println(subLink.text());
			switch (i){
				case 1:
					kodPKD = subLink.text();
					i=2;
					break;
				case 2:
					nazwa = subLink.text();
					i=1;
					subPKD = new SubPKD(kodPKD,nazwa);
					listPKD.add(subPKD);
					break;
				default:
			}
		}
		PKD pkd = new PKD(listPKD);
		System.out.println(pkd.toString());*/
	}
}
