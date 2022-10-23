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

INSERT INTO TB_PROFESSOR (id, nome) VALUES (1, 'Pedro da Paz');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (2, 'Laura Barros');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (3, 'Maria Vitória da Cunha');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (4, 'Alexandre Souza');
INSERT INTO TB_PROFESSOR (id, nome) VALUES (5, 'Helena Lopes');

INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('EEL5105', 90, 'Circuitos e Técnicas Digitais');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5401', 36, 'Introdução à Computação');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5402', 108, 'Programação Orientada a Objetos I');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('INE5403', 108, 'Fundamentos de Matemática Discreta para Computação');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('MTM3100', 72, 'Pré-Cálculo');
INSERT INTO TB_DISCIPLINA (codigo, carga_horaria, nome) VALUES ('MTM3101', 72, 'Cálculo 1');

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01208A', 1, 'EEL5105', 1);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01208B', 1, 'EEL5105', 2);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03202A', 1, 'INE5401', 3);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03202B', 1, 'INE5401', 3);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03208A', 1, 'INE5402', 2);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('3208B', 1, 'INE5402', 4);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01205D', 1, 'INE5403', 1);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('01205C', 1, 'INE5403', 4);

INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('08213', 1, 'MTM3101', 4);
INSERT INTO TB_TURMA (codigo, vagas_ofertadas, codigo_disciplina, id_professor) VALUES ('03235', 1, 'MTM3101', 4);

--  EEL5105
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'EEL004', 1, 7);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'EEL004', 1, 8);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'LABSDG', 3, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'LABSDG', 3, 6);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208A', 'LABSDG', 3, 7);


--INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01208B', 'CTC304', 1, 2);

--  INE5401
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03202A', 'CTC102', 2, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03202A', 'CTC102', 2, 6);


--  INE5402
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'CTC301', 0, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'CTC301', 0, 6);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'CTC301', 0, 7);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'LIICT3', 2, 7);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'LIICT3', 2, 8);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('03208A', 'LIICT3', 2, 9);

--  INE5403
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 0, 1);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 0, 2);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 1, 3);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 1, 4);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 3, 0);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('01205D', 'EFI204', 3, 1);

--  MTM3101
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 1, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 1, 6);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 4, 5);
INSERT INTO TB_TURMA_HORARIOS(turma_codigo, sala, dia_semana_id, horario_id) VALUES ('08213', 'EFI305', 4, 6);