import discord

class MyClient(discord.Client):

    async def on_ready(self):
        print('Logged on as', self.user)
        await self.get_channel(857109283790520352).send('```' + "봇이 켜졌습니다." + '```')

    async def on_message(self, message):
        # don't respond to ourselves
        if message.author == self.user:
            return

        if message.content.startswith('resend'):
            await message.channel.send('```' + message.content.replace('resend','').lstrip() + '```')
        elif message.content.startswith('list'):
            s = ""
            cnt = 0
            for n in self.get_all_members():
                cnt = cnt + 1
                s += '{0}. {1}\n'.format(cnt, n)
            await message.channel.send('```'+ s + '```')
        elif message.content.startswith('get'):
            for n in self.get_all_members():
                await message.channel.send(n)

    async def on_disconnect(self):
        print('Disconnect ', self.user)
        await self.get_channel(857109283790520352).send('```' + "봇이 꺼졌습니다." + '```')



client = MyClient()
client.run('ODU3MDkzODcyNjQ3OTI5ODc2.YNKk3w.ao1ijqeqJBkKBmORwnlSU3YOZME')
