<!DOCTYPE html>
<html>
    <#include "layout.ftl">

<#macro page_body>
<h1> Aulas </h1>

<div>
    <table>
        <tr>
            <th>Dia</th>
            <th>Horario</th>
            <th>Quantidade de alunos</th>

        </tr>
        <#list turmas>

            <#items as turma>
            <tr>
                <td>${turma.dia}</td>
                <td>${turma.horario}</td>
                <td>${turma.qntalunos}</td>
            </tr>
            </#items>
        </#list>
    </table>
</div>

</#macro>
</html>

