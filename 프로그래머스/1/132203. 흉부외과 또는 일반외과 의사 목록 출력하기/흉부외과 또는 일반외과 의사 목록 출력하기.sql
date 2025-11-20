select DR_NAME,	DR_ID, MCDP_CD,	date_format(HIRE_YMD, "%Y-%m-%d") as d
from doctor
where mcdp_cd="CS" or mcdp_cd="GS"
order by d desc, dr_name asc