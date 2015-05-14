##Notes API Assignment
=========================

####Description:

The following application is a RESTful, JSON Notes-taking API.  Capabilities include creating a new note, retrieving a single note, retrieving all notes and retrieving all notes containing a specified search string.  See below for example API calls.

### Pre-requisites
* Maven: version 3.2+
* JDK: version 1.7+
* Internet connection 

#### API Calls:

* [1] Create a new note
<blockquote><strong>curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{"body" : "Pick up milk!"}' http://localhost/api/notes</strong>
<p>** Note: Please included the additional header 'Content-Type' as shown above.  I was getting an error using curl when this was omitted.</p></blockquote>
* [2] Get an individual note 
<strong><blockquote>curl -i -H "Accept: application/json" -X GET http://localhost/api/notes/0</blockquote></strong>
* [3] Get all notes
<strong><blockquote>curl -i -H "Accept: application/json" -X GET http://localhost/api/notes</blockquote></strong>
* [4] Get all notes containing a text string
<strong><blockquote>curl -i -H "Accept: application/json" -X GET http://localhost/api/notes?query=forget</blockquote></strong>

### Running the application
After downloading the source code from the git repository, execute the following command from a CI shell.

<strong><blockquote>mvn clean install -Dmaven.tomcat.port=80 tomcat:run</blockquote></strong>

This will start the embedded maven-tomcat container on port 80.  You should then be able to test the api calls using curl or a REST client browser plugin 


### Design Notes & Considerations
* The application was created using the following open-source tools & APIs
1) Spring & SpringMVC
2) Jackson REST API
3) Maven
4) Tomcat (runs as an embedded container through maven)

No data persistence framework or Database was used given the time-constraint.  In a real production environment we would've opted to leverage some open-source solution such as MyBatis, Hibernate, TopLink, EclipseLink, etc... along with a relational DB such as MySQL, Oracle, Postgres, etc... or NoSQL (non-relational) DB such as MongoDB, Cassandra, HBase, etc...

### Answers to 'Additional Design Notes & Consideration'

<p>Q. How well does your note-searching-api scale or not scale? How would you make your search more efficient?</p>
<p>A.  So long as the size and number of notes does not grow too large and we have plenty of heap space, our "HashMap DataStore" should function ok.  In a production environment we obviously would care about things like data retention, server stability, design architecture, reporting, etc... and would opt to use at the very least a database (relational or non-relational) to store the data.  I typically opt to implement a data persistence layer as well as I feel it provides the proper decoupling and data abstraction in alignment with what's considered "best practices".  Since our application data is extremely simple (basically key/value pairs), a NoSQL database might be the more suitable option.</p>

Other "performance" improvement strategies in general might include:

* Use a caching tool like EhCache or Coherence
* Add an index to the body value (although this performance is lost with double wild-card searches using %{body}%)
* Look at using a text search tool like SOLR
* Importing the data into a data ware house for reporting
* DB partitioning
* Reverse text searching

A lot of these seem like overkill given the simplicity of the application, but are performance-improvement strategies nontheless.

How would you add security to your API?
* Implementing Basic Authentication or OAuth
* Use secure URL (https)

What features should we add to this API next?
* Delete & update are the obvious operations that are missing
* Adding support for adding or updating multiple notes in a single call

How would you test the API?
* Use Spring's MockRestServiceServer
* Use any mocking framework (JMock, EasyMock, Mockito)
* Use mock services running through SoapUI
* Using the the RestTemplate as I did in TestNotesRestAPI.java
