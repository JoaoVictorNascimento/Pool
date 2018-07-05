<!DOCTYPE html>
<html>
    <#include "layout.ftl">

<#macro page_body>
<h1> Modalidades </h1>

<div>
    <table>
        <tr>
            <th>Modalidade</th>
        </tr>
        <#list modalidades>

            <#items as modalidade>
            <tr>
                <td>${modalidade.disciplina}</td>
            </tr>
            </#items>
        </#list>
    </table>
</div>

</#macro>
</html>

