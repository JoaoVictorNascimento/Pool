<!DOCTYPE html>
<html>
    <#include "layout.ftl">

<#macro page_body>
<h1> Alunos </h1>

    <table>
        <tr>
            <th>Name</th>
            <!-- <th>Modalidade</th> -->
            <th>Deletar</th>
            <th>Atualizar</th>

        </tr>
        <#list students>

            <#items as student>
            <tr>
                <td>${student.nome}</td>
                <!-- <td></td> -->
                <td><input type="button" class="btn-delete" value="Deletar"></input></td>
                <td><input type="button"  class="btn-atualizar" value="Atualizar"></input></td>
            </tr>
            </#items>
        </#list>
    </table>
</#macro>
</html>

