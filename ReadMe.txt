
This project is a Nevernote REST API developed using Java and Maven.

This API provides the following resources mapped to the respective HTTP methods which supports creation, deletion of Notebooks and to retreive a specific Notebook or all Notebooks. 
POST   /notebooks
GET   /notebooks/{name}
GET   /notebooks
DELETE /notebooks/{name}

Example Model to create a new notebook using POST method and then use GET method to see the contents:
{
  "name": "string"
  "description": "string",
}


This API also provides the following resources mapped to the respective HTTP methods which supports creation, retreiving, updation and deletion of notes for a specified Notebook.
POST   /notebooks/{notebookName}/notes
GET   /notebooks/{notebookName}/notes/{title}
GET   /notebooks/{notebookName}/notes
DELETE /notebooks/{notebookName}/notes/{title}

Example Model to create a new note using POST method for a specific Notebook
{
  "title": "string",
  "body": "string",
  "tags": [ "string", "string", "string" ], 
}

Here is the example model that can be seen when GET method is used 
// "tags" - This is a string Array
// "createdTime" - This is created when a new note is added
// "lastModified" - This is created when a note is modified
{
  "title": "string",
  "body": "string",
  "tags": [ "string", "string", "string" ], 
  "createdTime": "string",
  "lastModified": null
}

Tools, technologies used for developing this API: 
Java 1.8.0_171
Maven
Spring MVC 
JUnit for unit tests
Spring Tool Suite 3.9.4
Postman HTTP client to test the REST calls
