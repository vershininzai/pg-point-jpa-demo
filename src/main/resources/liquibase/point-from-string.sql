create OR REPLACE function pointFromString(s varchar) returns point
as
$$
BEGIN
    Return point(SPLIT_PART(REPLACE(s, '(', ''), ',', 1)::float, SPLIT_PART(REPLACE(s, ')', ''), ',', 2)::float);
END;
$$
    Language 'plpgsql';
