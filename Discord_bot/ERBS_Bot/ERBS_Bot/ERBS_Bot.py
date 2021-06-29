import discord, requests
from Data import *

class ERBS(discord.Client):
    global icon_link
    global icon_dict

    async def on_ready(self):
        print('Logged on as', self.user)
        await self.get_channel(857109283790520352).send('```' + "봇이 켜졌습니다." + '```')

    async def on_message(self, message):
        # don't respond to ourselves
        if message.author == self.user:
            return

        if message.content.lower().startswith('!nomal') | (message.content.split(' ')[0].lower() == '!n'):
            print('normal')
            await self.mk_send(message, 'n')

        if message.content.lower().startswith('!rank') | (message.content.split(' ')[0].lower() == '!r'):
            print('rank')
            await self.mk_send(message, 'r')

        if (message.content.lower().startswith('!status') | (message.content.split(' ')[0].lower() == '!s')):
            print('status')
            await self.mk_send(message, 's')

    async def mk_send(self, msg, mode = 'n'):
        if(mode == 's'):
            try:
                if(msg.content.split(' ')[1].lower() == 'h'):
                    await msg.channel.send('```!status/!s NickName Season(0 = nomar, 1 = 1, 2 = free 2, 3 = 2) TeamMode(solo, duo, trio / 1, 2, 3)```')
                    return
                else:
                    nickname = msg.content.split(' ')[1]
            except e:
                print(e)


        else:
            try:
                if(msg.content.split(' ')[1].lower() == 'h'):
                    await msg.channel.send('```!normal(rank)/!n(r) NickName TeamMode(solo, duo, trio / 1, 2, 3)```')
                    return
                nickname = msg.content.split(' ')[1]
            except:
                await msg.channel.send('```닉네임을 입력해 주세요.```')
                return
        try:
            teamMod = msg.content.split(' ')[2]
            if((teamMod == 'solo') | (teamMod == 'duo') | (teamMod == 'trio') | (teamMod == '1') | (teamMod == '2') | (teamMod == '3')):
                pass
            else:
                await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                return
        except:
            await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
            return
        wait_message = await msg.channel.send('```Wait a second...```')
        data = Data(nickname)
        self.icon_link = data.icon_link
        print("code: ", data.code)
        if(data.code == 404):
            await wait_message.delete()
            await msg.channel.send('```존재하지 않는 닉네임입니다.```')
            return
        if(mode == 'n'): 
            id_list = data.get_Normal_Game(teamMod)
            s = ''
            if(len(id_list) != 0):
                for n in id_list:
                    s = s + str(n) + '\n'
            else:
                s = '매치가 존재하지 않습니다.'
            await wait_message.delete()
            await msg.channel.send(s)
        elif(mode == 'r'): 
            id_list = data.get_Rank_Game(teamMod)
            s = ''
            if(len(id_list) != 0):
                for n in id_list:
                    s = s + str(n) + '\n'
            else:
                s = '매치가 존재하지 않습니다.'
            await wait_message.delete()
            await msg.channel.send(s)
        elif(mode == 's'):
            embed=discord.Embed(title="Crussion", description="솔로")
            embed.set_thumbnail(url=self.icon_link)
            await wait_message.delete()
            await message.channel.send(embed=embed)
        else: 
            id_list = data.get_Normal_Game(teamMod)
            s = ''
            if(len(id_list) != 0):
                for n in id_list:
                    s = s + str(n) + '\n'
            else:
                s = '매치가 존재하지 않습니다.'
            await wait_message.delete()
            await msg.channel.send(s)

client = ERBS()
data = Data()

torken = data.Discord_torken
client.run(torken)
