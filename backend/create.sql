
    create table tb_candidatos (
       cep varchar(255),
        nome varchar(255),
        id_usuario bigint not null,
        primary key (id_usuario)
    );

    create table tb_candidaturas (
       id bigint generated by default as identity,
        data_candidatura timestamp,
        status integer,
        candidato_id bigint,
        vaga_id bigint,
        primary key (id)
    );

    create table tb_concursos (
       id bigint generated by default as identity,
        cedente varchar(255),
        escolaridade varchar(255),
        estado varchar(255),
        local varchar(255),
        prazo timestamp,
        salario double,
        vagas integer,
        empresa_id bigint,
        primary key (id)
    );

    create table tb_curriculos (
       id bigint generated by default as identity,
        bairro varchar(255),
        cep varchar(255),
        cidade varchar(255),
        complemento varchar(255),
        data_nascimento timestamp,
        estado varchar(255),
        estado_civil integer,
        facebook varchar(255),
        instagram varchar(255),
        linkedin varchar(255),
        nome varchar(255),
        numero varchar(255),
        pessoa_com_deficiencia boolean,
        resumo varchar(255),
        rua varchar(255),
        sexo integer,
        site varchar(255),
        telefone varchar(255),
        telefone_celular varchar(255),
        candidato_id bigint,
        primary key (id)
    );

    create table tb_empresas (
       bairro varchar(255),
        celular varchar(11),
        cep varchar(8),
        cidade varchar(255),
        cnpj varchar(255),
        complemento varchar(255),
        descricao TEXT,
        estado varchar(255),
        nome varchar(100),
        nome_responsavel varchar(100),
        numero varchar(255),
        qtd_funcionarios integer not null,
        rua varchar(255),
        seguimento varchar(255),
        telefone varchar(11),
        id_usuario bigint not null,
        primary key (id_usuario)
    );

    create table tb_experiencias (
       id bigint generated by default as identity,
        ano_conclusao integer,
        ano_inicio integer,
        atual boolean,
        cargo varchar(255),
        descricao varchar(255),
        mes_conclusao integer,
        mes_inicio integer,
        nome_empresa varchar(255),
        salario double,
        curriculo_id bigint,
        primary key (id)
    );

    create table tb_formacoes (
       id bigint generated by default as identity,
        ano_conclusao integer,
        ano_inicio integer,
        curso varchar(255),
        mes_conclusao integer,
        mes_inicio integer,
        nivel integer,
        nome_instituicao varchar(255),
        status integer,
        curriculo_id bigint,
        primary key (id)
    );

    create table tb_usuarios (
       type varchar(31) not null,
        id bigint generated by default as identity,
        data_cadastro timestamp,
        email varchar(100),
        senha varchar(100),
        tipo_usuario integer,
        token varchar(255),
        primary key (id)
    );

    create table tb_vagas (
       id bigint generated by default as identity,
        beneficios TEXT,
        data_alteracao timestamp,
        data_cadastro timestamp,
        descricao TEXT,
        localizacao varchar(255),
        nome varchar(255),
        quantidade integer not null,
        requisitos TEXT,
        salario double not null,
        status integer,
        tipo integer,
        empresa_id bigint,
        primary key (id)
    );

    alter table tb_curriculos 
       add constraint UK_rlr0lyal5gpyn40xjksl4ryc4 unique (candidato_id);

    alter table tb_usuarios 
       add constraint UK_hymsg6hpnk88xrsy9kdsuhur9 unique (email);

    alter table tb_candidatos 
       add constraint FK7ej66hactsyav2pyej6q4xjx8 
       foreign key (id_usuario) 
       references tb_usuarios;

    alter table tb_candidaturas 
       add constraint FKl4f6xrvrmvyfrtu9ngqqi08vx 
       foreign key (candidato_id) 
       references tb_candidatos;

    alter table tb_candidaturas 
       add constraint FK44h81va4ilyesi27ob670ln8i 
       foreign key (vaga_id) 
       references tb_vagas;

    alter table tb_concursos 
       add constraint FK7q9friaf4kjwo6sibyejilhne 
       foreign key (empresa_id) 
       references tb_empresas;

    alter table tb_curriculos 
       add constraint FK6u8qq0wctcjax2w32aff32adk 
       foreign key (candidato_id) 
       references tb_candidatos;

    alter table tb_empresas 
       add constraint FK5ssb1cvj0g0njl322371i5i77 
       foreign key (id_usuario) 
       references tb_usuarios;

    alter table tb_experiencias 
       add constraint FK3r9q6l6bj5a8qyly7fk1fsv1p 
       foreign key (curriculo_id) 
       references tb_curriculos;

    alter table tb_formacoes 
       add constraint FKabpy5731s4kv3am6sqb3i4f9l 
       foreign key (curriculo_id) 
       references tb_curriculos;

    alter table tb_vagas 
       add constraint FK2s7r1665spgq9ab5wgom6bl05 
       foreign key (empresa_id) 
       references tb_empresas;
