/*SET FOREIGN_KEY_CHECKS=0.*/

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `dailyquiz` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `dailyquiz` ;

-- -----------------------------------------------------
-- Table `dailyquiz`.`Membro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dailyquiz`.`Membro` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `email` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `senha` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `dataNascimento` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `dailyquiz`.`Questionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dailyquiz`.`Questionario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `dataDisponivel` DATETIME NULL DEFAULT NULL,
  `dataLimite` DATETIME NULL DEFAULT NULL,
  `idMembroCriador` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Questionario_Membro1_idx` (`idMembroCriador` ASC),
  CONSTRAINT `fk_Questionario_Membro1`
  FOREIGN KEY (`idMembroCriador`)
  REFERENCES `dailyquiz`.`Membro` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `dailyquiz`.`Questao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dailyquiz`.`Questao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idQuestionario` INT(11) NOT NULL,
  `idAlternativaCorreta` INT(11) NOT NULL,
  `ordem` INT(11) NOT NULL,
  `pergunta` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_questao_questionario_idx` (`idQuestionario` ASC),
  INDEX `fk_Questao_Alternativa1_idx` (`idAlternativaCorreta` ASC),
  CONSTRAINT `fk_Questao_Alternativa1`
  FOREIGN KEY (`idAlternativaCorreta`)
  REFERENCES `dailyquiz`.`Alternativa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_questao_questionario`
  FOREIGN KEY (`idQuestionario`)
  REFERENCES `dailyquiz`.`Questionario` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `dailyquiz`.`Alternativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dailyquiz`.`Alternativa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ordem` INT(11) NOT NULL,
  `descricao` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `idQuestao` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alternativa_questao1_idx` (`idQuestao` ASC),
  CONSTRAINT `fk_alternativa_questao1`
  FOREIGN KEY (`idQuestao`)
  REFERENCES `dailyquiz`.`Questao` (`id`)
  )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `dailyquiz`.`RespostaQuestionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dailyquiz`.`RespostaQuestionario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `idMembro` INT(11) NOT NULL,
  `IdQuestionario` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_RespostaQuestionario_Membro1_idx` (`idMembro` ASC),
  INDEX `fk_RespostaQuestionario_Questionario1_idx` (`IdQuestionario` ASC),
  CONSTRAINT `fk_RespostaQuestionario_Membro1`
  FOREIGN KEY (`idMembro`)
  REFERENCES `dailyquiz`.`Membro` (`id`),
  CONSTRAINT `fk_RespostaQuestionario_Questionario1`
  FOREIGN KEY (`IdQuestionario`)
  REFERENCES `dailyquiz`.`Questionario` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `dailyquiz`.`RespostaQuestao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dailyquiz`.`RespostaQuestao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idRespostaQuestionario` INT(11) NOT NULL,
  `idQuestao` INT(11) NOT NULL,
  `idAlternativa` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_RespostaQuestao_RespostaQuestionario1_idx` (`idRespostaQuestionario` ASC),
  INDEX `fk_RespostaQuestao_Questao1_idx` (`idQuestao` ASC),
  INDEX `fk_RespostaQuestao_Alternativa1_idx` (`idAlternativa` ASC),
  CONSTRAINT `fk_RespostaQuestao_Alternativa1`
  FOREIGN KEY (`idAlternativa`)
  REFERENCES `dailyquiz`.`Alternativa` (`id`),
  CONSTRAINT `fk_RespostaQuestao_Questao1`
  FOREIGN KEY (`idQuestao`)
  REFERENCES `dailyquiz`.`Questao` (`id`),
  CONSTRAINT `fk_RespostaQuestao_RespostaQuestionario1`
  FOREIGN KEY (`idRespostaQuestionario`)
  REFERENCES `dailyquiz`.`RespostaQuestionario` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
