# nextflow-groogle-sheet

An example of Groogle integration in Nextflow

Reading a Google Sheet to feed the pipeline and writing results into same the sheet

## Steps

- Create an account at https://console.cloud.google.com/
- Create a project
- Enable Google Sheet API https://console.cloud.google.com/apis/api/sheets.googleapis.com/
- Create a service account https://console.cloud.google.com/iam-admin/serviceaccounts/create and download the creds json
- Create a Google Sheet and share it with your service account (i.e. share with the email of the service created)
- Create a tab into the sheet and named `test`
- Edit cell A2 and write a sentence 

If all goes well you'll have:
- a `service.json`
- a shared Google sheet. The id of the sheet is in the url when you're editing it

In a console run following steps:

`git clone git@github.com:jagedn/nextflow-groogle-sheet.git`

`cd nextflow-groogle-sheet`

`curl -s https://get.nextflow.io | bash` 

`GOOGLE_APPLICATION_CREDENTIALS=./PATH_TO_YOUR_SERVICE.json ./nextflow run test.nf --sheetId "1llupsxxxxxxxx-jBI" --sheet test`

If all goes well your Google Sheet will be updated with the execution result