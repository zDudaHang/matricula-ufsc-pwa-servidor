INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (0, '07:30', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (1, '08:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (2, '09:10', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (3, '10:10', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (4, '11:00 - 11:50', true);

INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (5, '13:30', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (6, '14:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (7, '15:10', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (8, '16:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (9, '17:10 - 18:00', true);

INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (10, '18:30', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (11, '19:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (12, '20:20', false);
INSERT INTO TB_HORARIO (id, horario, is_ultimo_horario_periodo) VALUES (13, '21:10 - 22:00', false);

INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (0, 'Segunda');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (1, 'Terça');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (2, 'Quarta');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (3, 'Quinta');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (4, 'Sexta');
INSERT INTO TB_DIA_SEMANA (id, nome) VALUES (5, 'Sábado');

INSERT INTO TB_PROFESSOR (id, nome) VALUES (1, 'Kratos');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (2, 'Amanda Ripley');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (3, 'Ash Ketchum');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (4, 'Connor');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (5, 'William Billy Hope');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (6, 'Aloy');

INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('EEL5105', 90, 'Circuitos e Técnicas Digitais');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5401', 36, 'Introdução à Computação');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5402', 108, 'Programação Orientada a Objetos I');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5403', 108, 'Fundamentos de Matemática Discreta para Computação');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('MTM3100', 72, 'Pré-Cálculo');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('MTM3101', 72, 'Cálculo 1');

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01208A', 5, 'EEL5105', 1);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01208B', 5, 'EEL5105', 2);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03202A', 5, 'INE5401', 3);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03202B', 5, 'INE5401', 3);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03208A', 5, 'INE5402', 2);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03208B', 5, 'INE5402', 5);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01205D', 50, 'INE5403', 1);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01205C', 2, 'INE5403', 6);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('08213', 5, 'MTM3101', 4);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03235', 5, 'MTM3101', 4);

--  EEL5105
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'EEL004', 0, 7);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'EEL004', 0, 8);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'LABSDG', 0, 9);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'LABSDG', 0, 10);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'LABSDG', 0, 11);

INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208B', 'EEL003', 4, 0);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208B', 'EEL003', 4, 1);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208B', 'LABSDG', 4, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208B', 'LABSDG', 4, 6);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208B', 'LABSDG', 4, 7);

--  INE5401
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03202A', 'CTC102', 2, 9);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03202A', 'CTC102', 2, 10);

INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03202B', 'CTC101', 1, 3);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03202B', 'CTC101', 1, 4);

--  INE5402
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'LIICT3', 3, 0);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'LIICT3', 3, 1);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'LIICT3', 3, 2);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'CTC301', 3, 7);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'CTC301', 3, 8);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'CTC301', 3, 9);

INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208B', 'LIICT3', 1, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208B', 'LIICT3', 1, 6);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208B', 'LIICT3', 1, 7);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208B', 'CTC302', 2, 2);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208B', 'CTC302', 2, 3);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208B', 'CTC302', 2, 4);

--  INE5403
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 0, 1);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 0, 2);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 1, 1);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 1, 2);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 2, 10);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 2, 11);

INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205C', 'EFI201', 2, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205C', 'EFI201', 2, 6);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205C', 'EFI201', 2, 7);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205C', 'EFI201', 2, 8);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205C', 'EFI204', 3, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205C', 'EFI204', 3, 6);

--  MTM3101
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 0, 12);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 0, 13);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 4, 10);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 4, 11);

INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03235', 'EFI303', 0, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03235', 'EFI303', 0, 6);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03235', 'EFI305', 1, 8);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03235', 'EFI305', 1, 9);

-- ALUNOS JAH MATRICULADOS PARA GERAR FILA DE ESPERA
INSERT INTO TB_ALUNO(matricula, iaa, nome_usuario, senha, token) VALUES ('0a5f5e94-a75c-47ad-bdcd-7bf9a5c41379', 10, 'aluno1', '$2a$10$flrGqSdZ1qlYyb9Kz/Y92eHR42cfhg5hPfJeKp.HBYdmnrcpfiTcS', NULL);
INSERT INTO TB_ALUNO(matricula, iaa, nome_usuario, senha, token) VALUES ('681c7019-7d64-48f3-803b-96b653e5f276', 10, 'aluno2', '$2a$10$G5YGEgZXrsupn5cAugkjAukV2RE5DEjDCBBl3EbQ3AXuqcPxoEri2', NULL);

INSERT INTO TB_PEDIDO_MATRICULA(deve_notificar_aluno_ganhou_vaga, deve_notificar_aluno_perdeu_vaga, iaa_aluno, vagas_ofertadas, aluno_matricula, turma_codigo) VALUES (FALSE, FALSE, 10, 2, '0a5f5e94-a75c-47ad-bdcd-7bf9a5c41379', '01205C');
INSERT INTO TB_PEDIDO_MATRICULA(deve_notificar_aluno_ganhou_vaga, deve_notificar_aluno_perdeu_vaga, iaa_aluno, vagas_ofertadas, aluno_matricula, turma_codigo) VALUES (FALSE, FALSE, 10, 2, '681c7019-7d64-48f3-803b-96b653e5f276', '01205C');