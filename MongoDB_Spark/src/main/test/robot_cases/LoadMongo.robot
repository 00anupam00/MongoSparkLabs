*** Settings ***
*** Variables ***
${APP}  uftHelp
${URL}  www.google.co.in
${BROWSER}  CHROME

*** Test Cases ***
[TC-001]-First RF test-Launching the browser and search and launch the "uftHelp" Application on Google.com
    Launch Browser
    Search Application on Google
    Launch Application



*** Keywords ***