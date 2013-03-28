## WBA2 SoSe13 Aufgaben Phase 1

**Aufgabe 1**  
Erklären Sie kurz die Begriffe Wohlgeformtheit, Validität und Namespaces im Bezug auf XML und XML-Schema.  

*Wohlgeformtheit*  
Unter Wohlgeformtheit bei XML versteht man die Übereinstimmung der Elementtypbezeichnung im Start- und Endtag.
`<wohlgeformt>Beispiel</wohlgeformt>`  

Stimmen die Bezeichnungen nicht überein (z.B. durch Schreibfehler) oder wurden die Tags vertauscht, so wird ein Fehler ausgegeben.  
`<nichtwohlgeformt>Tags stimmen nicht überein</wohlgeformt>` -> Fehler  

```
<wohlgeformt>  
     <nichtwohlgeformt>Tags wurden vertauscht</wohlgeformt> 
</nichtwohlgeformt>
```
    
    
- *Validität*  
Ein XML-Dokument gilt als _valide_, ist also gültig, wenn es zum einen wohlgeformt ist und zum anderen von der entsprechenden Dokumenttyp-Definition DTD ableitbar ist.
Die DTD steht zu Beginn des XML Dokuments und stellt eine Deklaration der Elementtypen dar, die in der XML Datei Verwendung finden.  
Bei einer DTD wird anschließend geprüft, ob alle geforderten Informationen enthalten sind und in der richtigen Reihenfolge stehen. 
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

**Aufgabe 3**  
b) Betrachten Sie nun andere Rezepte auf der Webseite http://www.chefkoch.de.  
Beschreiben Sie welche Gemeinsamkeiten die Rezepte hinsichtlich ihrer Daten haben und worin Sie sich unterscheiden.


-Lösung Aufgabe 3b-





c) Arbeiten Sie die Kriterien heraus, die für die Entwicklung einer XML-Schema-Datei beachtet werden müssen.
Die Schema-Datei soll die Struktur für eine XML-Datei definieren, in der mehrere unterschiedliche Rezepte gespeichert werden können. 
Ziel ist es, dass das XML-Schema möglichst restriktiv ist,so dass in der XML-Datei möglichst semantisch sinnvolle Daten bezüglich der 
Rezepte gespeichert werden können. Ziehen Sie beim Aufstellen der Kriterien u.A. folgende Fragestellungen in Betracht:
  * Welche Daten müssen in simple und welche in complex-types abgebildet werden?  
  * Für welche Daten ist die Abbildung in Attributen sinnvoller?  
  * Welche Datentypen müssen für die Elemente definiert werden?  
  * Welche Restriktionen müssen definiert werden?


-Lösung Aufgabe 3c-


**Aufgabe 5**  
Diskutieren Sie, warum es sinnvoll ist Daten in Formaten wie XML oder JSON zu speichern.  
Stellen Sie außerdem die beiden Formate gegenüber und erläutern Sie kurz deren Vor- und Nachteile.

-Lösung Aufgabe 5-
