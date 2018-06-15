<!DOCTYPE html>
<html>
<#include "layout.ftl">

<#macro page_body>
<h1> Cadastro de Alunos</h1>
    <form action = "#" method = "post">

        <div class="campo">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" style="width: 25em" value="">
        </div>

        <div class="campo">
            <label for="cpf">CPF</label>
            <input type="text" name="cpf" size="9" maxlength="9"> - <input type="text" name="cpf2" size="2" maxlength="2">
        </div>

        <div class="campo">
            <label for="idade">Idade</label>
            <input type="text" id="idade" name="idade" style="width: 5em" value="">
        </div>

        <div class="campo">
            <label for="endereco">Endereço</label>
            <input type="text" id="endereco" name="endereco" style="width: 40em" value="">
        </div>

        <br>
        <div class align="center">
            <input class="square_btn" type="submit" value="Cadastrar">
        </div>
    </form>
</#macro>