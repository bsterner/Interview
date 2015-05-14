--
--    Create note table for storing notes
--

create table note (
    id int not null identity,
    body varchar(512) not null
);

