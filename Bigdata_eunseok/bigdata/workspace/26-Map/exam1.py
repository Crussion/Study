import folium

location = [37.504430130745035, 127.02448732256488]
location2 = [37.5030642734999, 127.02426419914951]
location3 = [37.50313236473377, 127.02592716867129]

map_osm = folium.Map(location=location, zoom_start=17)
map_osm.save('map_osm.html')

# icon : 'home', 'glass', 'flag', 'star', 'bookmark', ....
map_osm = folium.Map(location=location, zoom_start=17)

marker = folium.Marker(location, popup='신논현역',
                       icon=folium.Icon(color='red', icon='glass'))
marker.add_to(map_osm)

marker = folium.Marker(location2, popup='이젠',
                       icon=folium.Icon(color='red', icon='cloud'))
marker.add_to(map_osm)

marker = folium.CircleMarker(location3, popup='이젠',
                       radius=100, color='#3186cc', fill_color='#3186cc')
marker.add_to(map_osm)

map_osm.save('map_osm1.html')