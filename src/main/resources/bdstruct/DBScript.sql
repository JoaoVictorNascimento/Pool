-- MySQL Script generated by MySQL Workbench
-- Qua 13 Jun 2018 11:38:39 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema default_schema
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema poolsystem
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `poolsystem` ;

-- -----------------------------------------------------
-- Schema poolsystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `poolsystem` DEFAULT CHARACTER SET utf8 ;
USE `poolsystem` ;

-- -----------------------------------------------------
-- Table `poolsystem`.`Modalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poolsystem`.`Modalidade` (
  `idModalidade` INT NOT NULL AUTO_INCREMENT,
  `Disciplina` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idModalidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poolsystem`.`Aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poolsystem`.`Aula` (
  `idAula` INT NOT NULL AUTO_INCREMENT,
  `Horario` VARCHAR(11) NULL DEFAULT NULL,
  `Dia` VARCHAR(11) NULL DEFAULT NULL,
  `Modalidade_idModalidade` INT NOT NULL,
  `Professor` VARCHAR(45) NULL DEFAULT NULL,
  `QntAlunos` INT NOT NULL,
  PRIMARY KEY (`idAula`, `Modalidade_idModalidade`),
  INDEX `fk_Aula_Modalidade1_idx` (`Modalidade_idModalidade` ASC),
  CONSTRAINT `fk_Aula_Modalidade1`
    FOREIGN KEY (`Modalidade_idModalidade`)
    REFERENCES `poolsystem`.`Modalidade` (`idModalidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poolsystem`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poolsystem`.`Aluno` (
  `idAluno` INT NOT NULL AUTO_INCREMENT,
  `FichaCadastral` MEDIUMBLOB NULL DEFAULT NULL,
  `FichaMedica` MEDIUMBLOB NULL DEFAULT NULL,
  `Contrato` MEDIUMBLOB NULL DEFAULT NULL,
  `FichaAnamnese` MEDIUMBLOB NULL DEFAULT NULL,
  `Nome` VARCHAR(45) NULL DEFAULT NULL,
  `Rg` VARCHAR(20) NULL DEFAULT NULL,
  `Cpf` VARCHAR(20) NULL DEFAULT NULL,
  `Aula_idAula` INT NOT NULL,
  `Aula_Modalidade_idModalidade` INT NOT NULL,
  `Idade` INT NULL DEFAULT NULL,
  `Sexo` VARCHAR(10) NULL,
  `Endereco` VARCHAR(45) NULL,
  `Telefone` VARCHAR(11) NULL,
  `Responsavel` VARCHAR(45) NULL,
  `DataNascimento` DATE NULL,
  `Idoso` TINYINT(1) NULL,
  PRIMARY KEY (`idAluno`, `Aula_idAula`, `Aula_Modalidade_idModalidade`),
  INDEX `fk_Aluno_Aula1_idx` (`Aula_idAula` ASC, `Aula_Modalidade_idModalidade` ASC),
  CONSTRAINT `fk_Aluno_Aula1`
    FOREIGN KEY (`Aula_idAula` , `Aula_Modalidade_idModalidade`)
    REFERENCES `poolsystem`.`Aula` (`idAula` , `Modalidade_idModalidade`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `poolsystem`.`ListadeEspera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poolsystem`.`ListadeEspera` (
  `idListadeEspera` INT NOT NULL AUTO_INCREMENT,
  `Nome_aluno` VARCHAR(45) NULL DEFAULT NULL,
  `Telefone` VARCHAR(45) NULL DEFAULT NULL,
  `Horario` VARCHAR(45) NULL DEFAULT NULL,
  `Modalidade_idModalidade` INT NULL DEFAULT NULL,
  `Observacao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idListadeEspera`),
  INDEX `Modalidade_idx` (`Modalidade_idModalidade` ASC),
  CONSTRAINT `Modalidade_idModalidade`
    FOREIGN KEY (`Modalidade_idModalidade`)
    REFERENCES `poolsystem`.`Modalidade` (`idModalidade`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
