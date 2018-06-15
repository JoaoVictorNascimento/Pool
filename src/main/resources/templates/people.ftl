<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<#--<h1>Welcome ${person}</h1>-->

<#list person as person>

<div class="post">
    <p>${person.name}:${person.cpf} ${person.rg} ${person.idPessoa}
</div>
</#list>

</body>
</html>