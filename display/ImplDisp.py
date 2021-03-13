def display(n, block_orientation, rotate, inreverse):
    # create matrix device
    serial = spi(port=0, device=0, gpio=noop())
    device = max7219(serial, cascaded=n or 1, block_orientation=block_orientation,
                     rotate=rotate or 0, blocks_arranged_in_reverse_order=inreverse)

    
    while True:
        with canvas(device) as draw:
            count=0
            lista2D = dbconn ()
            while count <len(lista2D):
                draw.point((lista2D[count]), fill="white")
                count+=1
def dbconn():
    
    conn = pymysql.connect(host="***", port=, user="***", passwd="***", db="***")


    cur=conn.cursor()
    cur.execute("SELECT id_boulder from display ORDER BY id_display DESC LIMIT 1")

    row = cur.fetchall()
    res = int(''.join(map(str, row[0])))
    print (res)

    wartos = res
    sql = "SELECT id_hold FROM boulder_hold where id_boulder LIKE %s"

    cur.execute(sql, wartos)
    row = cur.fetchall()

    listaIdHold = list (row)

    lenght = len(listaIdHold)

    i = 0
    while i<lenght:
        listaIdHold[i] = int(''.join(map(str, listaIdHold[i])))
        i+=1

    print(listaIdHold)

    wartos = listaIdHold[0]
    sql = "SELECT x,y FROM hold where id_hold LIKE %s"

    cur.execute(sql, wartos)
    row = cur.fetchall()
    test_list = row
    res =[list(ele) for ele in test_list]

    i=1
    while i < lenght:
        wartos = listaIdHold[i]
        sql = "SELECT x,y FROM hold where id_hold LIKE %s"

        cur.execute(sql, wartos)
        row = cur.fetchall()
        test_list = row
        res.extend([list(ele) for ele in test_list])
        i+=1
        
    print (res)
    
    cur.close()
    conn.close()