import discord, requests
from Data import *

class MyClient(discord.Client):

    async def on_ready(self):
        print('Logged on as', self.user)
        await self.get_channel(857109283790520352).send('```' + "봇이 켜졌습니다." + '```')

    async def on_message(self, message):
        # don't respond to ourselves
        if message.author == self.user:
            return

        if message.content.lower().startswith('!nomal') | message.content.lower().startswith('!n'):
            nickname = message.content.split(' ')[1]
            teamMod = message.content.split(' ')[2]
            data = Data(nickname)
            for n in data.get_Normal_Game(teamMod):
                await message.channel.send(n)

        if message.content.lower().startswith('!rank') | message.content.lower().startswith('!r'):
            nickname = message.content.split(' ')[1]
            teamMod = message.content.split(' ')[2]
            data = Data(nickname)
            for n in data.get_Rank_Game(teamMod):
                await message.channel.send(n)

client = MyClient()
torken = 'ODU3MDkzODcyNjQ3OTI5ODc2.YNKk3w.ao1ijqeqJBkKBmORwnlSU3YOZME'
client.run(torken)
