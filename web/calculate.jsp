<%--
Copyright 2015 Drew Bryant and Patrick Lathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CSC 330 Homework 2</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/main.css">
    <link rel="import" href="includes/headerfooter.html">
  </head>
  <body>
      <header>
        <script>
          var content = document.querySelector('link[rel="import"]').import;
          var headerLine = content.querySelector('#headerLine');
          document.body.appendChild(headerLine.cloneNode(true));
        </script>
      </header>
      <label>Investment Amount</label>
      <span>${calc.amount}</span>
      <br>
      <label>Yearly Interest Rate</label>
      <span>${calc.rate}</span>
      <br>
      <label>Number of Years</label>
      <span>${calc.years}</span>
      <br>
      <label>Future Value</label>
      <span>${calc.futureAmount}</span>
      <script>
        var content = document.querySelector('link[rel="import"]').import;
        var footerLine = content.querySelector('#footerLine');
        document.body.appendChild(footerLine.cloneNode(true));
      </script>
  </body>
</html>
