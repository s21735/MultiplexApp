insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 1, 1,'0',1);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 2, 1,'0',1);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 3, 1,'0',1);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 4, 1,'0',1);

insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 1, 1,'0',1);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 2, 1,'0',1);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 3, 1,'0',1);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 4, 1,'0',1);



insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 1, 2,'0',2);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 2, 2,'0',2);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 3, 2,'0',2);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('a', 4, 2,'0',2);

insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 1, 1,'0',2);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 2, 1,'0',2);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 3, 1,'1',2);
insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values('b', 4, 1,'1',2);





-- do $$
--     begin
--         for r in 1..10 loop
--                 for k in 97..106 loop
--                         for z in 16..19 loop
--
--                                 insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values((select(chr(k))),r,1,'0',z);
--
--                             end loop;
--                     end loop;
--             end loop;
--     end;
-- $$;
--
-- do $$
--     begin
--         for r in 1..10 loop
--                 for k in 97..106 loop
--                         for z in 20..23 loop
--
--                                 insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values((select(chr(k))),r,2,'0',z);
--
--                             end loop;
--                     end loop;
--             end loop;
--     end;
-- $$;
--
--
-- do $$
--     begin
--         for r in 1..10 loop
--                 for k in 97..106 loop
--                         for z in 24..30 loop
--
--                                 insert into seat(row,seatnumber,roomnumber,taken,screeningfk) values((select(chr(k))),r,3,'0',z);
--
--                             end loop;
--                     end loop;
--             end loop;
--     end;
-- $$;
