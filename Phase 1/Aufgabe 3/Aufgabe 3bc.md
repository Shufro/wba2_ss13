**Aufgabe 3**  
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
   Rezeptname, Zusatzinfo, Bildbeschreibung, Schwierigkeitsgrad, Beschreibung
   ```
   <br>
  **Complex-type**: komplexe Typen, bei denen Elemente weitere Elemente oder Attribute enthalten können sowie leere Elemente an sich.  
  <br>
  Für die komplexen Typen eignen sich Elemente, die neben einer einfachen Bezeichnung **notwendige Zusatzinformationen** benötigen.  
  Für Rezepte wären das beispielsweise die **Zutat**, die an sich einen **Zutatnamen** haben, aber für die auch die erforderte **Menge** in enstprechender **Einheit** angegeben werden muss. Simple Typen reichen hier nicht, weil bei mehreren Zutaten die eindeutige Zuordnung vorhanden sein muss.  
  Weiterhin finden sich komplexe Typen in den jeweiligen "Oberkategorien" wie der Zutatenmenge, die selbst mehrere Elemente enthält oder die Zubereitung, zu der nicht nur eine Beschreibung reicht, sondern auch Daten zum Schwierigkeitsgrad und den Zubereitungszeiten angegeben werden sollten.  
```
  Rezept (Rezeptid, Rezeptname,Bild,Zutaten,Zubereitung)
  Bild (Bildbeschreibung)
  Zutaten (mehrere Zutaten)
  Zutat(Zutatname, Einheit, Menge)
  Zubereitung(Arbeitszeit, Brennwert, Schwierigkeitsgrad, Beschreibung)
  ```
     
     

 * _Datentypen zuordnen_  
Basisdaten für Elemente und Attribute definiert durch "http://www.w3.org/2001/XMLSchema"  
**string, integer, boolean, decimal, date, time**  
Den einzelnen Elementen muss ein Datentyp zugeordnet werden um **semantisch sinnvolle Werte** zu gewährleisten. So muss ein Name im Idealfall als String, eine ID als Integer Zahl oder ein Datum als date definiert werden.  
<br>
Für den Rezeptseite bedeutet dies u.a. eine Rezeptid oder Zutatennummer als Integer, Mengeneinheiten und Beschreibungen als String. 
```
  Rezeptid(Integer), Rezeptname(String), Zusatzinfo(String), Bild, Bildbeschreibung(String), Zutatnr(Integer),Zutatname(String), Menge(decimal), Einheit(String), Arbeitszeit(Integer), Schwierigkeitsgrad(String),  
  Brennwert(Integer), Beschreibung(String)
  ```


 * _Restriktionen festlegen_  
**Angemessene Stringlänge bei Texten**  
Zur Reduktion der Komplexität und einer besseren Übersicht ist es sinnvoll bestimmte Werte wie die Stringlänge auf einen angemessenen Umfang einzuschränken.  
Sinnvoll wäre dies beispielsweise beim Rezeptnamen, um diesen möglichst treffend und allgemein zu halten. Bei der Zusatzinfo, damit eine kurze Besonderheit oder genauere Bezeichnung getroffen werden kann, die an sich eher eine Vorschau darstellt anstatt in eine genaue Beschreibung zu verfallen.
Oder auch beim Zutatennamen, der eindeutig gefasst werden kann.
```
  Rezeptname: max. 100 Zeichen 
  Zusatzinfo: max. 200 zeichen
  Bildbeschreibung: max. 40 Zeichen
  Zutatname: max. 40 Zeichen 
  Schwierigkeitsgrad: max. 10 Zeichen
  ```
  
  **Sinnvolle Zahlenwerte und Wertgrenzen**  
  Damit beim Rezept mit semantisch sinnvollen Daten gearbeitet werden kann, eignet es sich für bestimmte Elemente Wertgrenzen festzulegen.
  Generell sollten bei Angaben von Zeit oder Mengen nur positive Werte erlaubt sein.  
  Dazu kommt eine realistische Maximalgrenze bestimmter Werte, damit ein Rezept nicht beispielsweise für 1000 Portionen ausgelegt wird, eine Zubereitungszeit von 40 Stunden hat oder unmögliche Kalorienzahlen annehmen.

 ```
  Zutatnr: > 0 und < 40 
  Menge: > 0   
  Arbeitszeit: > 0 Minuten/Stunden  und > 5 Stunden 
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
  
