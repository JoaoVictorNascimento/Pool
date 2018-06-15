<!DOCTYPE html>
<html>
    <#include "layout.ftl">

<#macro page_body>
<h1> Alunos </h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>CPF</th>
            <th>RG</th>

        </tr>
        <#list persons>

            <#items as person>
            <tr>
                <td>${person.idPessoa}</td>
                <td>${person.name}</td>
                <td>${person.cpf}</td>
                <td>${person.rg}</td>
            </tr>
            </#items>
        </#list>
    </table>
</#macro>
</html>

