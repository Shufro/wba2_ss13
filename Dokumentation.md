#Web-basierte Anwendungen 2: Verteilte Systeme

### Dokumenatation Phase 1   



**Aufgabe 1**  
Erklären Sie kurz die Begriffe Wohlgeformtheit, Validität und Namespaces im Bezug auf XML und XML-Schema.  

<br>
*Wohlgeformtheit*  
Unter Wohlgeformtheit bei XML versteht man die Einhaltung definierter Syntaxregeln wie die Übereinstimmung der Elementtypbezeichnung im Start- und Endtag.  
`<wohlgeformt>Beispiel</wohlgeformt>`  

Stimmen die Bezeichnungen nicht überein (z.B. durch Schreibfehler) oder wurden die Tags vertauscht, so wird ein Fehler ausgegeben.  
`<nichtwohlgeformt>Tags stimmen nicht überein</wohlgeformt>` -> Fehler  

```
<wohlgeformt>  
     <nichtwohlgeformt>Tags wurden vertauscht</wohlgeformt> 
</nichtwohlgeformt>
```   

Weiterhin wird vorausgesetzt, dass die einzelnen Elemente Bestandteil eines Wurzelelementes sind und Attribute im Anfangstag mit Anführungszeichen (oder ' ') versehen werden.  

```
<wurzelelement attname="attbeschreibung">
    <subelement attname2="attbeschreibung2"></subelement>
</wurzelelement>
```

Bezieht das ELement Inhalt, so muss dieser innerhalb eines Start- und Endtags stehen. Hat das Element keinen Inhalt ist auch die Form
`<Elementname />` möglich.


<br>
 
*Validität*  
Ein XML-Dokument gilt als _valide_, ist also gültig, wenn es zum einen wohlgeformt ist und zum anderen auf Gültigkeit geprüft wurde.
Es wird darauf geachtet, dass alle geforderten Elemente eines bestimmten Typs enthalten sind bzw. enthalten sein können und in der richtigen Reihenfolge stehen.
Werden Regeln gesetzt, die zwischen gültig und ungültig unterscheinden, so besteht die Gültigkeit darin, dass diese Regeln erfüllt werden.


Zur Prüfung gibt es zwei Möglichkeiten:  

- Variante 1: Dokumenttyp-Definition DTD  
Die DTD steht zu Beginn des XML Dokuments als interne/externe DTD und stellt eine Deklaration der Elementtypen dar, die in der XML Datei Verwendung finden.  
  
Beispiel  

```
<?xml version="1.0"?>

<!DOCTYPE wurzelName [
     <!Element wurzelName (subElement1, subElement2, subElement3)>  
     
     <!Element subElement1 (#PCDATA)>  
     <!Element subElement2 (#PCDATA)>  
     <!Element subElement3 (#PCDATA)>
]>

-- Beginn XML-Datei --

```

- Variante 2: XML Schema

```
<?xml version="1.0"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

<xs:element name="wurzel">
  <xs:complexType>
    <xs:sequence>
      <xs:element elementname="bespielelement" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
  <xs:attribute name="beispielattribute"/>
</xs:element>

</xs:schema>
```

<br>

*Namespaces*  
Durch die freie Wahl von Element- und Attributnamen, können identische Bezeichnungen bei unterschiedliche Anwendungsbereiche auftreten. 
Diese mehrdeutigen Namen, stehen jeweils in unterschiedlichem Kontext, müssen aber vom Programm auseinander gehalten werden.  
Um die Eindeutigkeit der Namen zu gewährleisten, wurden _Namensräume_ eingeführt, die in der Regel über eine URL referenziert werden.  

In der Anwendung kann das über eine Zuordnung eines Präfixes geschehen:  
```
'nr' wird als Kürzel für die Namensraum eingerichtet
<bspNamespace xmlns:nr="http://Namensraum.com/beispiel">
...
</bspNamespace>
```  
Wird beispielsweise die Bezeichnung "Vorname" in mehreren Fällen gebraucht, 
so kann über das zuvor deklarierte Präfix ein spezieller Kontext ausgewählt werden.  
`<nr:Vorname>Dennis</nr:Vorname>`  

<br>  
**Aufgabe 2**  
a) Erzeugen Sie ein XML-Dokument, dass die Daten des folgenden Formulars vollständig erfasst:  
http://www.gm.fh-koeln.de/~vsch/anmeldung/gruppenanmeldung.html  
Füllen Sie das Dokument mit einem Beispieldatensatz. Achten Sie darauf, dass über das Formular mehrere Personen gleichzeitig erfasst werden können.
Wichtig: Es sollte nicht die HTML-Struktur der Webseite in der XML-Datei abgebildet werden, sondern die zu übertragenden Daten.  
<br>
**Lösung**   
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%202/Aufgabe2.xml  
Anmerkungen zur Ausarbeitung in Kommentaren zur Datei

b) Erzeugen Sie ein JSON-Dokument, dass zu ihrem XML-Dokument äquivalent ist.    
<br>
**Lösung**   
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%202/Aufgabe2.json  
<br>

Im vorhandenen JSON Dokument wurde der Datentyp string benutzt. Zusätzlich unterstützt JSON aber u.a. auch die Formate Integer und Boolean.  
In dieser Hinsicht wäre auch eine Variante möglich, die diese Datentypen mit einbaut. Denkbar wäre wären Definitionen der folgenden Daten.  
```
Boolean für die Auswahl des Schlagzeuges, Auswahl ob vorhanden oder nicht. Ebenso die Bestätigung der AGB's bei entsprechender Vorlage.
   "Schlagzeug" : true (oder false)
   "AGBakzeptiert" : true (oder false, wobei dies zur Einscheibung nicht genügen wird)
   
Integer Wert für Auwahl der Erfahrener mit vorheriger Zuordnung. 1 = Anfänger, 2 = Fortgeschrittener, 3 = Profi
  "Erfahrung" : 2
```
<br>


**Aufgabe 3**  
a) Gegeben ist folgendes Rezept: http://www.chefkoch.de/rezepte/24641006006067/Lenchen-s- Schokoladenkuchen.html  
Entwickeln Sie ein XML-Dokument, in dem die Daten des Rezeptes abgebildet werden. Achten Sie darauf, dass das Dokument semantisch möglichst reichhaltig ist.
Bei dieser und den folgenden Aufgaben lassen sie bitte die Daten in der Marginalspalte auf der rechten Seite weg.
<br>
**Lösung**    
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%203/Aufgabe3a.xml  

Alternative Möglichkeit in Kommentaren im Dokument beschrieben.  
Anmerkung: Die Elemente "Kommentare" sind an sich keine Informationen, die das eigentliche Rezept mit Informationen beschreiben und könnten deshalb vernachlässigt werden.  
Für den Bezug zur Aufgabe 4, in der die Kommentare aber notwendige Informationen darstellen, wurde dieser Elementtyp gleich mit einbezogen.  
Zudem ist die Ausarbeitung der DTD in dieser und auch bereits in Aufgabe 2 nicht unbedingt notwendig gewesen. Diese dienten einfach nur der Kontrolle der Validierung.  


b) Betrachten Sie nun andere Rezepte auf der Webseite http://www.chefkoch.de.  
Beschreiben Sie welche Gemeinsamkeiten die Rezepte hinsichtlich ihrer Daten haben und worin Sie sich unterscheiden.

<br>
_Gemeinsamkeiten_  
Rezepte auf der Seite haben immer einen **Rezeptname** mit eigener **Rezeptid** (URL Referenz).  
Die ID ist notwendig und lässt sich daraus entnehmen, dass man über unterschiedliche Kategorien auf das gleiche Rezept kommen kann.

Jedes Rezept setzt eine **Zutatenliste** vorraus und jede einzelne Zutat wird mit  **Menge und Einheit** sowie zugehörigem **Zutatenname** beschrieben.
Die Werte beziehen sich auf eine bestimmte **Anzahl Portionen**. Diese Angabe ist von Bedeutung um eine Umrechnung zu ermöglichen.

Dazu kommt eine Erklärung der **Zubereitung** in der die **unterschiedliche Merkmale** wie **Arbeitszeit**, **Schwierigkeitsgrad in festgelegten Domänen (simpel,normal, pfiffig)** und **Brennwert p.P** angegeben sind und eine **Beschreibung der Zubereitun** verfasst wird. 

<br>
_Unterschiede_  
Grundsätzlich setzt jedes Rezept die **Angaben der Gemeinsamkeiten** voraus.  
Als zusätzliche Daten können jedem Rezept, neben dem Rezeptnamen. noch eine **optionale Kurzbeschreibung** hinzugefügt werden.  
Es ist möglich ein oder mehrere **Bild(er)** hochzuladen, welches mit entspechendem Titel versehen werden.
Die Zutatenliste, die grundsätzlich Angaben enthalten muss, kann in **variable Unterkategorien** eingeteilt werden. 
Ebenso können für die **Zubereitung weitere Merkmale** zur Ruhezeit oder   
Koch-/Backzeit angegeben werden.

<br>
_Datentypen_  
Die einzelnen Informationen werden mit **Zahlenwerte** (u.a. bei Zutatenmenge,
Arbeitszeit und Brennwert) oder **Textwerten** beschrieben, gegebenfalls werden diese zusätzlich verlinkt.
Bei Kommentaren würde zusätzlich ein Datenformat für den Kommentarzeitpunkt eingebunden werden, was z.B. mit dem Typ dateTime in XML realisiert werden kann.


<br>
</br>
c) Arbeiten Sie die Kriterien heraus, die für die Entwicklung einer XML-Schema-Datei beachtet werden müssen.
Die Schema-Datei soll die Struktur für eine XML-Datei definieren, in der mehrere unterschiedliche Rezepte gespeichert werden können.  
Ziel ist es, dass das XML-Schema möglichst restriktiv ist,so dass in der XML-Datei möglichst semantisch sinnvolle Daten bezüglich der 
Rezepte gespeichert werden können. Ziehen Sie beim Aufstellen der Kriterien u.A. folgende Fragestellungen in Betracht:  
  * Welche Daten müssen in simple und welche in complex-types abgebildet werden?  
  * Für welche Daten ist die Abbildung in Attributen sinnvoller?  
  * Welche Datentypen müssen für die Elemente definiert werden?  
  * Welche Restriktionen müssen definiert werden?
 

   <br>  
   
**Kriterien**  
   
 * _entsprechenden Namensraum definieren_  
 Der Bezug zu einem Namensraum ermöglicht die genaue Zuordnung der Elementnamen, sofern diese mehrmals vorkommen. Benutze Elemente in den XML Dokumenten entstammen den Bezeichnungen von "http:// www.chefkoch.de ".
    <br>  

 * _eindeutige Element-/Attributnamen_  
  Die gewählten Bezeichnungen als Element-/Attributnamen sollten aussagekräftig, eindeutig und möglichst kurz sein.   
  ```
  Rezept, Rezeptname, Zusatzinfo, Bild, Bildbeschreibung, Zutaten, Zutatnr, Zutatname, Menge, Einheit, Zubereitung, Arbeitszeit, Schwierigkeitsgrad,  
  Brennwert, Beschreibung
  ```
  
  <br> 
  
 * _passende Elementtypen identifizieren_  
  Elementtypen lassen sich generell in 2 Arten einstufen und unterscheiden sich entsprechend in ihrer Deklaration:  
<br> 
**Simple-type**: einfache Elemente, die keine weiteren Elemente oder Attribute enthalten.  
In Bezug auf die Rezeptseiten eignet sich dieser Typ bei Namen oder Beschreibungen, die frei formuliert werden können und **keine Zusatzinformationen** benötigen wie der **Rezeptname**, eine Kurzbeschreibung oder die Anleitung zur Zubereitung.  
   
   ```
   Rezeptname, Zusatzinfo, Bildbeschreibung, Schwierigkeitsgrad, Beschreibung, Url, Username, Text 
   ```
   <br>
  **Complex-type**: komplexe Typen, bei denen Elemente weitere Elemente oder Attribute enthalten können sowie leere Elemente an sich.  
  <br>
  Für die komplexen Typen eignen sich Elemente, die neben einer einfachen Bezeichnung **notwendige Zusatzinformationen** benötigen.  
  Für Rezepte wären das beispielsweise die **Zutat**, die an sich einen **Zutatnamen** haben, aber für die auch die erforderte **Menge** in enstprechender **Einheit** angegeben werden muss. Simple Typen reichen hier nicht, weil bei mehreren Zutaten die eindeutige Zuordnung vorhanden sein muss.  
  Weiterhin finden sich komplexe Typen in den jeweiligen "Oberkategorien" wie der Zutatenmenge, die selbst mehrere Elemente enthält oder die Zubereitung, zu der nicht nur eine Beschreibung reicht, sondern auch Daten zum Schwierigkeitsgrad und den Zubereitungszeiten angegeben werden sollten.  
```
  Rezept (Rezeptid, Rezeptname,Bild,Zutaten,Zubereitung, Kommentare)
  Bild (Bildbeschreibung)
  Zutaten (mehrere Zutaten)
  Zutat(Zutatname, Einheit, Menge)
  Zubereitung(Arbeitszeit, Brennwert, Schwierigkeitsgrad, Beschreibung)
  Arbeitszeit+Koch/Backzeit+Ruhezeit(Dauer, Einheit)
  Kommentare(mehrere Kommentare)
  Kommentar(Username, Zeitpunkt, Text)
  ```
 <br>   
 * sinnvolle Abbildung überlegen (Element/Attribut)  
Beim definieren der einzelnen Werte überlegen, ob eine Abbildung in Attribut oder Element gewählt werden soll. Attribute werden eingesetzt, um ein Datenobjekt mit möglichen Zusatzinformationen zu beschreiben. Dadurch wird ein bestimmtes Element genauer Charakterisiert und hebt sich von anderen, gleichartigen Elementen ab.
Generell bestimmen sie wie normale Elemente die Daten.
<br>
 ```
  Rezept genauer beschrieben durch: ID, URL, Kategorie
  Zutat kann mit nötigen Informationen wie: Name Einheit, Menge versehen werden
  Bei Zeitangaben kann die Einheit und Dauer genauer angegeben werden
  Bild mit jeweiliger Beschreibung und Quelle
  ``` 

 * _Datentypen zuordnen_  
Basisdaten für Elemente und Attribute definiert durch "http://www.w3.org/2001/XMLSchema"  
**string, integer, boolean, decimal, date, time**  
Den einzelnen Elementen muss ein Datentyp zugeordnet werden um **semantisch sinnvolle Werte** zu gewährleisten. So muss ein Name im Idealfall als String, eine ID als Integer Zahl oder ein Datum als date definiert werden.  
<br>
Für den Rezeptseite bedeutet dies u.a. eine Rezeptid oder Zutatennummer als Integer, Mengeneinheiten und Beschreibungen als String. 
```
  Rezeptid(Integer), Rezeptname(String), Zusatzinfo(String), Bildbeschreibung(String), URL(anyUri)
  Zutatnr(Integer),Zutatname(String), Menge(decimal), Einheit(String), Arbeitszeit(Integer), 
  Schwierigkeitsgrad(String),Brennwert(Integer), Beschreibung(String), Username(string),
  Zeitpunkt(dateTime), Text(string)
  ```

 * _Restriktionen festlegen_  
**Angemessene Stringlänge bei Texten**  
Zur Reduktion der Komplexität und einer besseren Übersicht ist es sinnvoll bestimmte Werte wie die Stringlänge auf einen angemessenen Umfang einzuschränken.  
Sinnvoll wäre dies beispielsweise beim Rezeptnamen, um diesen möglichst treffend und allgemein zu halten. Bei der Zusatzinfo, damit eine kurze Besonderheit oder genauere Bezeichnung getroffen werden kann, die an sich eher eine Vorschau darstellt anstatt in eine genaue Beschreibung zu verfallen.
Oder auch beim Zutatennamen, der eindeutig gefasst werden kann.  
Mögliche Einschränkungen sind:
```
  Rezeptname: max. 50 Zeichen 
  Zusatzinfo: max. 200 zeichen
  Bildbeschreibung: max. 40 Zeichen
  Zutatname: max. 50 Zeichen 
  Schwierigkeitsgrad: max. 10 Zeichen
  ```
  
  **Sinnvolle Zahlenwerte und Wertgrenzen**  
  Damit beim Rezept mit semantisch sinnvollen Daten gearbeitet werden kann, eignet es sich für bestimmte Elemente Wertgrenzen festzulegen.
  Generell sollten bei Angaben von Zeit oder Mengen nur positive Werte erlaubt sein.  
  Dazu kommt eine realistische Maximalgrenze bestimmter Werte, damit ein Rezept nicht beispielsweise für 1000 Portionen ausgelegt wird, eine Zubereitungszeit von 40 Stunden hat oder unmögliche Kalorienzahlen annehmen.
  
  Mögliche Einschränkungen sind:
 ```
  Zutatnr: > 0 und < 40 
  Menge: > 0   
  Arbeitszeit: > 0 Minuten/Stunden 
  Portionen: > 0 und < 30
  ```  
  

  **Akzeptierte Werte vorgeben**  
  Für bestimmte Elemente kann es sinnvoll sein eine festgelegte Auswahl an Werten vorzugeben, um die Eindeutigkeit zu gewährleisten.  
  Beim Schwierigkeitsgrad reicht die Auswahl in simpel, normal, pfiffig, um jeder Niveaustufe genau eine Bezeichnung zuzuordnen. Bei freier Benennung würde daraus folgen, dass jeder Benutzer für die einfachste Stufe eine eigene Bezeichnung finden würde wie "leicht", "easy", "anfänger", die aber alle die selbe Aussage treffen.
  Festgelegte Werte vereinfachen die Übersichtlichkeit.


 * _Informationen erzwingen oder festlegen_  
 Bei bestimmten Daten kann es sinnvoll sein grundlegende Werte als **default Werte** zu definieren, um bei fehlenden Angaben eine Einheitlichkeit zu erzeugen.
 Wird beispielsweise kein Kaloriengehalt angegeben, so erfolgt die festlegung auf "keine Angabe", da 0 Kalorien semantisch nicht realistisch wären.
<br>

  Eine weitere Möglichkeit ist das einstufen der **Attribute** in **optional** oder **required**. Vereinfachen könnte das die genaue Zuordnung eines Rezeptes zu eienr Rezeptid oder das festlegen einer Zeiteinheit zur entsprechenden Wertangabe.  
<br>

d) Erstellen Sie nun ein XML-Schema auf Basis ihrer zuvor definierten Kriterien. 
Generieren Sie nun auf Basis des Schemas eine XML-Datei und füllen Sie diese mit zwei
unterschiedlichen und validen Datensätzen.  
<br>

**Lösung**  
XML Schema   
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%203/Aufgabe3d.xsd  
<br>
daraus abgeleitete XML Datei mit Beispieldatensätzen  
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%203/Aufgabe3d.xml  

Begründungen finden sich in Kommentaren im jeweiligen Dokument.  

Anmerkung:  
Während der Ausarbeitung gab es unterschiedliche Modelle.  
In einer fand die Unterteilung der Zutaten, angelehnt an die Webseite, folgendermaßen statt.

```
     <Zutaten>
		<Zutatengruppe>
 			<Zutat/>
		<Zutatengruppe 
	</Zutaten>
```

Dieser Aufbau wurde vorgenommen, um die Einteilung in Zutatengruppen zu ermöglichen.
Da sich diese Komplexität bei der folgenden Aufgabe als hinderlich herausstellte (durch das führen von mehreren Listen in Listen), 
wurde der Einfachheit halber diese Struktur in der letzendlichen Ausarbeitung vereinfacht und orientiert sich nun speziell 
am Beispiel aus Aufgabe 3a.  

```
     <Zutaten>
 	       <Zutat/>
           <Zutat/>
           <Zutat/>
    </Zutaten>
```  
<br>

Auch Aufgabe 3a machte im Nachhinein noch eine Veränderung durch. Speziell für Aufgabe 4, wurden Kommentare hinzugefügt.

Alte Versionen:
Beispieldatensatz Lenzchen  
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%203/alte%20Version/Aufgabe3a%20ohne%20Kommentare.xml  

Schema  
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%203/alte%20Version/Aufgabe3d_mit_ZGruppen.xsd   
XML Datei  
https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/Aufgabe%203/alte%20Version/Aufgabe3d_mit_ZGruppen.xml

  



**Aufgabe 4**  
In dieser Aufgabe entwickeln Sie mit Hilfe des JAXB Frameworks ein Java- Programm, 
welches die XML-Datei aus der vorigen Aufgabe einlesen, modifizieren und ausgeben kann.  

a) Erzeugen Sie zunächst aus der Schema-Datei der vorherigen Aufgabe Java- Objekte.
Nutzen Sie dazu den XJC-Befehl über das Terminal und fügen Sie die generierten Klassen ihrem Java-Projekt hinzu. 
Alternativ zur Terminal-Eingabe existiert ein JAXB Eclipse Plug-In welches hier herunter geladen werden
kann: http://sourceforge.net/projects/jaxb-builder.  
Dieses kann wie ein normales Plugin in Eclipse eingebunden werden. 
Zur Nutzung des Plugins klicken Sie mit der rechten Maustaste auf die Schema-Datei 
und wählen Sie aus dem Kontextmenü Generate => JAXB-Classes... und folgen Sie den weiteren Anweisungen in dem Dialogfenster.
<br>
**Lösung**   
https://github.com/Shufro/wba2_ss13/tree/master/Phase%201/src/jaxb/objects  
<br>

b) Entwickeln Sie nun das Java-Programm. Es soll die XML-Datei öffnen, einlesen und die enthaltenen Daten über die Konsole wieder ausgeben.
Benutzen Sie bitte bei der Bearbeitung der Aufgabe die generierten JAXB-Klassen aus der vorherigen Teilaufgabe.  

c) Erweitern Sie ihr Programm so, dass es möglich ist, über die Konsole neue Kommentare zu einem Rezept hinzuzufügen.
Benutzen Sie auch hierfür die generierten JAXB-Klassen. Erstellen Sie ein Menü, dass in der Konsole angezeigt wird
. Über dieses Menü sollen die Auswahl der Funktionen, zum Ausgeben der Daten und Erstellen neuer Kommentare, möglich sein.
<br>

**Lösung**   
Entwickeltes Programm  

https://github.com/Shufro/wba2_ss13/blob/master/Phase%201/src/aufgabe4/RezepteProgramm.java

<br>

**Aufgabe 5**  
Diskutieren Sie, warum es sinnvoll ist Daten in Formaten wie XML oder JSON zu speichern.  
Stellen Sie außerdem die beiden Formate gegenüber und erläutern Sie kurz deren Vor- und Nachteile.


XML und JSON **speichert** die reinen **Daten** ohne irgendwelche formalen Vorschriften zu geben und ermöglicht einen einfachen **Transport** dieser. 
Die Dateien sind **Software-,Sprachen- und Hardwareunabhängig**, wodurch eine große **Interoperabilität** geschaffen ist und ein Datensatz 
in vielen unterschiedlichen Anwendungen zum Einsatz kommen kann.  
Beide Dateiformate werden im Klartext beschrieben. Sie sind selbstbeschreibend und durch die eigene Benennung der "Tags",
lassen sich die Daten auch relativ leicht vom Menschen lesen.  

Die Benutzung solcher Dateiformate (die sich besonders darauf spezialisieren die reinen Informationen in Form von Daten zu übertragen, ohne bereits auf Darstellung zu achten), 
liegt in der Flexibilität und Einfachheit. Besitzer großer Datenbestände können diese leicht weiterleiten und weiterverarbeiten.  
<br>  
In Absprache mit Entwicklern beispielsweise, die sich um die eigentliche Präsentation der Informationen auf Webseiten etc. kümmern, entsteht durch die festgesetzte Struktur  
der Datensätze ein einheitliches Schema, das vorgibt welche Informationen benötigt werden.
<br>
Der Vorteil von JSON gegenüber XML Dokumenten ist, dass die Dateigröße im Vergleich kleiner ausfällt, da sie vom Umfang der Zeichen her geringer sind.
JSON hat eine einfache Syntax und der "Markup" Overhead fällt im Vergleich  kleiner aus. Sie sind deshalb auch schneller zu schreiben.  
Für das Lesen, bietet XML ebenfalls eine gute Übersicht, wird aber bei vielen Informationen zunehmend komplex.

Da JSON für "JavaScript Object Notation" steht, wird der Vorteil deutlich, dass JSON Dateien direkt als JavaScript ausgeführt werden können.  
Dieses Dateiformat ist eher für die Anwendung auf objekt-orientierte System ausgelegt Dazu kommt, dass XML dokument-ortienert und JSON daten-orientiert arbeitet.

Der Nachteil gegenüber XML besteht in der geringen Anzahl an Datentypen, die unterstützt werden.



<br>

</br>
ausgearbeitet von Dennis Meyer, Sose 2013
